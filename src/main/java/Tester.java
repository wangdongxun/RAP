import com.google.gson.Gson;
import com.taobao.rigel.rap.common.utils.MockjsRunner;
import com.taobao.rigel.rap.project.bo.Action;
import com.taobao.rigel.rap.project.bo.Module;
import com.taobao.rigel.rap.project.bo.Page;
import com.taobao.rigel.rap.project.bo.Project;
import freemarker.template.TemplateException;
import org.apache.commons.collections.CollectionUtils;
import org.apache.struts2.util.ContainUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.*;

import com.taobao.rigel.rap.mail.*;

/**
 * Created by Bosn on 2014/8/16.
 */
public class Tester {
    public static void main(String[] args) {
        String oldStr = "{\"createDateStr\":\"2016-07-30\",\"user\":{\"name\":\"吴俊杰\",\"id\":2},\"id\":1,\"version\":\"0.0.0.10\",\"introduction\":\"\",\"name\":\"project\",\"moduleList\":[{\"id\":1,\"introduction\":\"\",\"name\":\"某模块（点击编辑后双击修改）\",\"pageList\":[{\"id\":1,\"introduction\":\"\",\"name\":\"某页面\",\"actionList\":[{\"id\":1,\"name\":\"接口测试A\",\"description\":\"\",\"author\":\"123\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"test\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":3,\"identifier\":\"reqParam\",\"name\":\"某请求参数123123\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":33,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":43,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":37,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":44,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":34,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":4,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":38,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]},{\"id\":2,\"name\":\"123\",\"description\":\"\",\"author\":\"吴俊杰\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"1231\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":39,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":27,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":5,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":28,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":6,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":40,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]}]}]},{\"id\":2,\"introduction\":\"\",\"name\":\"模块2\",\"pageList\":[{\"id\":2,\"introduction\":\"\",\"name\":\"页面\",\"actionList\":[{\"id\":3,\"name\":\"接口2\",\"description\":\"\",\"author\":\"吴俊杰\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"123\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":35,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":36,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]}]}]}]}";
        String newStr = "{\"createDateStr\":\"2016-07-30\",\"user\":{\"name\":\"吴俊杰\",\"id\":2},\"id\":1,\"version\":\"0.0.0.10\",\"introduction\":\"\",\"name\":\"project\",\"moduleList\":[{\"id\":1,\"introduction\":\"\",\"name\":\"某模块（点击编辑后双击修改）\",\"pageList\":[{\"id\":1,\"introduction\":\"\",\"name\":\"某页面\",\"actionList\":[{\"id\":11,\"name\":\"接口测试ADD\",\"description\":\"\",\"author\":\"123\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"test\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":3,\"identifier\":\"reqParam\",\"name\":\"某请求参数123123\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":33,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":43,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":37,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":44,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":34,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":4,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":38,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]},{\"id\":2,\"name\":\"接口测试UPDATE\",\"description\":\"\",\"author\":\"吴俊杰\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"1231\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":39,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":27,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":5,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":28,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":6,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"},{\"id\":40,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]}]}]},{\"id\":2,\"introduction\":\"\",\"name\":\"模块2\",\"pageList\":[{\"id\":2,\"introduction\":\"\",\"name\":\"页面\",\"actionList\":[{\"id\":3,\"name\":\"接口2\",\"description\":\"\",\"author\":\"吴俊杰\",\"version\":\"123\",\"status\":\"开发中\",\"requestType\":\"1\",\"requestUrl\":\"123\",\"responseTemplate\":\"\",\"requestParameterList\":[{\"id\":35,\"identifier\":\"reqParam\",\"name\":\"某请求参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}],\"responseParameterList\":[{\"id\":36,\"identifier\":\"resParam\",\"name\":\"某响应参数\",\"remark\":\"\",\"parameterList\":[],\"validator\":\"\",\"dataType\":\"number\"}]}]}]}]}";

        Gson gson = new Gson();

        Project oldProject = gson.fromJson(oldStr, Project.class);

        Project newProject = gson.fromJson(newStr, Project.class);

        GetChangeList(oldProject, newProject);
    }

    private static void GetChangeList(Project oldProject, Project newProject) {
        Set<Action> oldActionList = new HashSet<>();
        Set<Action> newActionList = new HashSet<>();

        for (Module module : oldProject.getModuleList()) {
            for (Page page : module.getPageList()) {
                oldActionList.addAll(page.getActionList());
            }
        }
        for (Module module : newProject.getModuleList()) {
            for (Page page : module.getPageList()) {
                newActionList.addAll(page.getActionList());
            }
        }

        List<Map<String, Object>> changeList = new ArrayList<>();
        Map<String, Object> item = null;
        for (Action action1 : newActionList) {
            boolean flag=false;
            for (Action action2 : oldActionList) {
                if (action1.getId() == action2.getId()) {
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                item = new HashMap<>();
                item.put("itemID", action1.getId());
                item.put("itemName", action1.getName());
                item.put("modifyType", "ADD");
                changeList.add(item);
            }
        }

        for (Action action1 : oldActionList) {
            boolean flag=false;
            for (Action action2 : newActionList) {
                if (action1.getId() == action2.getId()) {
                    flag=true;
                    break;
                }
            }
            if(!flag)
            {
                item = new HashMap<>();
                item.put("itemID", action1.getId());
                item.put("itemName", action1.getName());
                item.put("modifyType", "DELETE");
                changeList.add(item);
            }
        }


        for (Action action1 : newActionList) {
            for (Action action2 : oldActionList) {
                if (action1.getId() == action2.getId()) {
                    if (!action1.equals(action2)) {
                        item = new HashMap<>();
                        item.put("itemID", action1.getId());
                        item.put("itemName", action1.getName());
                        item.put("modifyType", "UPDATE");
                        changeList.add(item);
                    }
                }
            }
        }
    }
}
