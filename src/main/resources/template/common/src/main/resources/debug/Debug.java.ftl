import com.alibaba.fastjson.JSONObject;
import ${packageName}.Application;
import ${packageName}.repository.TicketRepository;
import ${packageName}.service.TicketCostService;
import ${packageName}.service.TicketService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

public class Debug {

    private static Logger logger = Logger.getLogger(Debug.class);

    public String defaultMethod(){

        return "welcome to debug .";
    }

    public String test(){
        //use Application.applicationContext.getBean("xxxxxxx",xxxxx.class) get beans
        return "";
    }

}
