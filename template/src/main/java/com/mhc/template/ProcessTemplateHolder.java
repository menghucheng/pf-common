/**
 * @desc ：
 * @author ：tigermeng.
 * @date ：9:21 PM 2019/3/16
 */
package com.mhc.template;

import com.mhc.template.context.ApplicationContextHolder;
import com.mhc.template.enums.BaseProcessEnum;
import com.mhc.template.model.Process;
import com.mhc.template.model.ProcessAction;
import com.mhc.template.model.ProcessTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author ：tigermeng.
 * @desc ：
 * @date ：9:21 PM 2019/3/16
 */
public class ProcessTemplateHolder {

    private static final Logger logger = LoggerFactory.getLogger(ProcessTemplateHolder.class);

//    private static List<Process> processList =

    public static <CONTEXT> void process(BaseProcessEnum process, CONTEXT context) {
        Assert.notNull(process, "processEnum is allowed null");
        String template = process.getTemplate();
        String pros = process.getProcess();

        //检查模板是否配置
        ProcessTemplate processTemplate= ApplicationContextHolder.getBean(template);
        Assert.notNull(template, "mhc.teplate.mhc.template.spring [" + template + "] is not config");

        //检查执行过程是否配置
        Map<String, Process> processMap = processTemplate.getProcesses();
        Assert.notEmpty(processMap, "mhc.teplate.mhc.template.spring [" + template + "]'s processes is not config!");

        Process proc = processMap.get(pros);
        Assert.notNull(proc, "process [" + pros + "] is not exits!");

        //检查执行链是否配置
        List<ProcessAction> actions = proc.getActions();
        Assert.notEmpty(actions, "mhc.teplate.mhc.template.spring[" + template + "'s process] is not config");

        doProcess(actions, context);
    }


    /**
     * doProcess
     *
     * @param actions
     * @param context
     * @param <CONTEXT>
     */
    @SuppressWarnings("unchecked")
    private static <CONTEXT> void doProcess(List<ProcessAction> actions, CONTEXT context) {
        logger.info("begin to perform actions");

        for (ProcessAction action : actions) {
            Assert.notNull(action, "action is null");
            action.getAction().process(context);
        }
        logger.info("end to perform action");
    }
}
