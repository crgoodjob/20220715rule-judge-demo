package cn.maitian.bss.modules.change.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.maitian.bss.modules.change.model.RuleLockRelation;
import cn.maitian.bss.modules.change.dao.RuleLockRelationMapper;
import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.model.RuleOccupy;
import cn.maitian.bss.modules.change.service.RuleLockRelationIService;
import cn.maitian.bss.modules.change.service.RuleLockSetIService;
import cn.maitian.bss.modules.change.vo.RuleLockRelationVO2;
import cn.maitian.bss.modules.change.vo.RuleManagerVO;
import cn.maitian.bss.modules.system.model.SysDept;
import cn.maitian.bss.modules.system.model.SysUser;
import cn.maitian.bss.modules.system.service.SysDeptIService;
import cn.maitian.bss.modules.system.service.SysUserIService;
import cn.maitian.bss.modules.system.vo.SysUserVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 异动锁定关系 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Service
public class RuleLockRelationServiceImpl extends ServiceImpl<RuleLockRelationMapper, RuleLockRelation> implements RuleLockRelationIService {

    @Autowired
    private SysUserIService sysUserIService;
    @Autowired
    private SysDeptIService sysDeptIService;
    @Autowired
    private RuleLockRelationMapper ruleLockRelationMapper;
    @Autowired
    private RuleLockSetIService ruleLockSetIService;

    @Override
    public List<RuleLockRelation> insertRuleLockRelationList(List<RuleLockSet> list) {
        List<RuleLockRelation> result = new ArrayList<>();
        for (RuleLockSet ta : list) {
            // 下属
            List<SysUserVO> subList = this.getSubordinateList(ta);
            for (SysUserVO u : subList) {
                RuleLockRelation rr = new RuleLockRelation();
                rr.setLockSetId(ta.getId());
                rr.setCreateType("1");
                rr.setSubordinateName(u.getUserName());
                rr.setSubordinateIdCard(u.getIdCard());
                rr.setSubordinateOldId(BigDecimal.valueOf(u.getOldUserId()));
                rr.setState("1");
                rr.setDataType("1");
                result.add(rr);
            }
        }
        saveBatch(result);
        return result;
    }
    /**
     * 查询某个对人的所有下属
     */
    private List<SysUserVO> getSubordinateList(RuleLockSet ta) {
        List<SysUserVO> result = new ArrayList<>();
        List<SysUser> sbList = new ArrayList<>();
        SysUserVO vo = sysUserIService.getUserVoByOldUserId(Integer.valueOf(ta.getAppointOldId().toString()));
        if (StringUtils.isBlank(vo.getShopId())) {
            QueryWrapper<SysDept> wrapper = new QueryWrapper<>();
            wrapper.eq("PARENT_ID", vo.getDeptId());
            wrapper.eq("del", "0");
            List<SysDept> depts = sysDeptIService.list(wrapper);

            if (depts != null && depts.size() > 0) {
                for (SysDept de : depts) {
                    QueryWrapper<SysUser> w2 = new QueryWrapper<>();
                    w2.eq("DEPT_ID", de.getId());
                    w2.eq("status", "1");
                    List<SysUser> temp = sysUserIService.list(w2);
                    // List<SysUserVO> temp = BeanUtil.copyToList(sbList, SysUserVO.class);
                    sbList.addAll(temp);

                    SysUser u = sysUserIService.getById(de.getManagerId());
                    // 暂时不判定职位，职等
                    RuleLockSet again = new RuleLockSet();
                    again.setAppointOldId(u.getOldUserId());
                    again.setAppointIdCard(u.getIdCard());
                    again.setAppointName(u.getUserName());
                    this.getSubordinateList(again);
                }
            } else {
                QueryWrapper<SysUser> w2 = new QueryWrapper<>();
                w2.eq("DEPT_ID", vo.getDeptId());
                w2.eq("status", "1");
                List<SysUser> temp = sysUserIService.list(w2);
                sbList.addAll(temp);
            }

        } else {
            QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
            wrapper.eq("SHOP_ID", vo.getShopId());
            wrapper.eq("STATUS", "1");
            List<SysUser> temp = sysUserIService.list(wrapper);
            sbList.addAll(temp);
        }

        for (SysUser u : sbList) {
            if (!u.getOldUserId().toString().equals(ta.getAppointOldId().toString())) {
                SysUserVO v = new SysUserVO();
                BeanUtil.copyProperties(u, v);
                result.add(v);
            }
        }
        return result;
    }

    @Override
    public List<RuleLockRelationVO2> selectRuleLockRelationVOs() {
        return ruleLockRelationMapper.selectRuleLockRelationVOs();
    }

    @Override
    public List<RuleManagerVO> getManagerInfo() {
        return ruleLockRelationMapper.getManagerInfoList();
    }

    /**
     * 查询最后参与盘点所需要的限量占用记录
     * @author ChangRui 
     * @date 2022/7/13 13:55
     * @param supName
     * @param supOldId 
     * @param supIdCard 
     * @param superList 
     * @return java.util.List<cn.maitian.bss.modules.change.model.RuleOccupy>
     */
    @Override
    public List<RuleOccupy> queryOccupy(String supName, BigDecimal supOldId, String supIdCard, List<RuleManagerVO> superList) {
        List<RuleLockSet> ruleLockSets = ruleLockSetIService.queryRuleLockSetList(superList);
        List<RuleLockRelation> ruleLockRelations = this.queryRuleLockRelationList(supOldId, ruleLockSets);
        return null;
    }
    
    /**
     * 根据异动锁定集合 查询 异动锁定关系
     * @author ChangRui 
     * @date 2022/7/13 14:04
     * @param supOldId 
     * @param ruleLockSetS 
     * @return java.util.List<cn.maitian.bss.modules.change.model.RuleLockRelation>
     */
    public List<RuleLockRelation> queryRuleLockRelationList(BigDecimal supOldId, List<RuleLockSet> ruleLockSetS) {
        if (ruleLockSetS != null && ruleLockSetS.size() > 0) {
            List<String> lockSetIds = new ArrayList<>();
            for (RuleLockSet vo : ruleLockSetS) {
                lockSetIds.add(vo.getId());
            }

            QueryWrapper wrapper = new QueryWrapper();
            wrapper.in("LOCK_SET_ID", lockSetIds);
            wrapper.eq("STATE", "1");
            wrapper.eq("SUBORDINATE_OLD_ID", supOldId);
            List<RuleLockRelation> result = getBaseMapper().selectList(wrapper);
            return  result;
        }
        return Lists.newArrayList();
    }
}
