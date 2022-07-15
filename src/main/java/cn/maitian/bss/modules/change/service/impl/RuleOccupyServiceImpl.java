package cn.maitian.bss.modules.change.service.impl;

import cn.maitian.bss.modules.change.model.RuleLockSet;
import cn.maitian.bss.modules.change.model.RuleOccupy;
import cn.maitian.bss.modules.change.dao.RuleOccupyMapper;
import cn.maitian.bss.modules.change.service.RuleOccupyIService;
import cn.maitian.bss.modules.change.vo.RuleLockRelationVO2;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.compress.utils.Lists;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 限量占用记录 服务实现类
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Service
public class RuleOccupyServiceImpl extends ServiceImpl<RuleOccupyMapper, RuleOccupy> implements RuleOccupyIService {

    @Override
    public List<RuleOccupy> insertRuleOccupyList(List<RuleLockSet> setList, List<RuleLockRelationVO2> relationList) {
        List<RuleOccupy> result = new ArrayList<>();
        for (RuleLockRelationVO2 rle : relationList) {
            for (RuleLockSet vo : setList) {
                if (rle.getSubordinateOldId().intValue() == vo.getAppointOldId().intValue()) {
                    RuleOccupy ro = new RuleOccupy();
                    ro.setCreateType("1");
                    ro.setLockSetId(rle.getLockSetId());
                    ro.setLockRelationId(rle.getId());
                    // ro.setSuperiorName("亓松松");
                    // ro.setSuperiorIdCard("371422198604042414");
                    // ro.setSuperiorOldId(BigDecimal.valueOf(21020));
                    ro.setOccupyDate(LocalDate.of(2022,8,1));
                    ro.setDataType("1");
                    ro.setState("1");
                    result.add(ro);
                }
            }
        }

        saveBatch(result);
        return result;
    }

    @Override
    public List<RuleOccupy> queryOccupyList(List<RuleLockSet> setList) {
        if (setList != null && setList.size() > 0) {
            List<RuleOccupy> result = Lists.newArrayList();
            // TODO 是查询出所有 setList 查询，还是单个 RuleLockSet 查询
            for (RuleLockSet vo : setList) {
                QueryWrapper<RuleOccupy> wrapper = new QueryWrapper<>();
                wrapper.eq("LOCK_SET_ID", vo.getId());
                //TODO 常量
                wrapper.eq("STATE", "1");
                // TODO 查询正式 和 本批次临时数据（通过本次批次ID）
                // wrapper.eq();

                //TODO 占用日期在异动锁定集合范围内
                // wrapper.ge()
                List<RuleOccupy> list = getBaseMapper().selectList(wrapper);
                result.addAll(list);
            }
            return result;
        }
        return Lists.newArrayList();
    }
}
