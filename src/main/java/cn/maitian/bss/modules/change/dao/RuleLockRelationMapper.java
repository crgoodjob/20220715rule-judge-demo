package cn.maitian.bss.modules.change.dao;

import cn.maitian.bss.modules.change.model.RuleLockRelation;
import cn.maitian.bss.modules.change.vo.RuleLockRelationVO2;
import cn.maitian.bss.modules.change.vo.RuleManagerVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 异动锁定关系 Mapper 接口
 * </p>
 *
 * @author liguo
 * @since 2022-07-08
 */
@Repository
public interface RuleLockRelationMapper extends BaseMapper<RuleLockRelation> {

    @Select("SELECT b.*,a.appoint_name,a.appoint_old_id,a.appoint_id_card FROM rule_lock_set a inner join rule_lock_relation b on a.id=b.lock_set_id")
    List<RuleLockRelationVO2> selectRuleLockRelationVOs();

    @Select("SELECT dd.id dept_id," +
            "       dd.dept_name," +
            "       dd.manager_id," +
            "       dd.parent_id," +
            //"       dd.parent_name," +
            "       u.user_name manager_name," +
            "       u.id_card," +
            "       u.old_user_id manager_old_id" +
            "  FROM (SELECT t.id," +
            "               t.dept_name," +
            "               t.manager_id," +
            "               t.parent_id" +
            //"               ,(SELECT a.dept_name" +
            //"                  FROM sys_department a" +
            //"                 where a.id = t.parent_id) parent_name" +
            "          FROM sys_department t" +
            "         start with t.parent_id = 'A6275675D8254075913102978DF9E00A'" +
            "                and t.del = '0'" +
            "        connect by prior t.id = t.parent_id" +
            "               and t.del = '0'" +
            "        union all" +
            "        SELECT p.id," +
            "               p.shop_name," +
            "               p.manager_id," +
            "               p.dept_id" +
            //"               ,(SELECT a.dept_name" +
            //"                  FROM sys_department a" +
            //"                 where a.id = p.dept_id) parent_name" +
            "          FROM sys_shop p" +
            "         where p.del = '0') dd" +
            "  left join sys_user u" +
            "    on dd.manager_id = u.id")
    List<RuleManagerVO> getManagerInfoList();
}
