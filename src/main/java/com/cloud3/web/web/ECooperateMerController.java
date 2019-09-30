package com.cloud3.web.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.cloud3.commons.constants.ZCloud3Constants;
import com.cloud3.commons.dto.ECooperateMer;
import com.cloud3.commons.response.QueryECooperateMerResponse;
import com.cloud3.commons.response.Result;
import com.cloud3.commons.service.ECooperateMerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: LiuHeYong
 * @create: 2019-05-22
 * @description: ECooperateMerController
 **/
@Controller
public class ECooperateMerController extends DefaultController {

    public static final Logger logger = LoggerFactory.getLogger(ECooperateMerController.class);

    @Reference(check = false, version = "${dubbo.service.version}", timeout = 60000)
    private ECooperateMerService eCooperateMerService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpServletResponse response;

    /**
     * @date: 2019/5/24
     * @param: [eCooperateMer]
     * @return: Result
     * @description: 详情
     */
    @ResponseBody
    @RequestMapping(value = ZCloud3Constants.CLOUD3 + "/queryECooperateMerInfo")
    public Result queryECooperateMerInfo(ECooperateMer eCooperateMer) {
        Result result = new Result();
        Map<String, Object> model = new HashMap<String, Object>(4);
        try {
            Optional<ECooperateMer> optDto =
                    Optional.ofNullable(eCooperateMerService.queryECooperateMerInfo(eCooperateMer));
            if (optDto.isPresent()) {
                model.put("eCooperateMer", optDto.get());
                result.setResultData(model);
                result.setResultCode(ZCloud3Constants.RESULT_SUCCESS);
                return result;
            } else {
                throw new Exception("该eCooperateMer不存在");
            }
        } catch (Exception e) {
            logger.error("系统异常", e);
            result.setResultCode(ZCloud3Constants.RESULT_FAIL);
            result.setResultMessage("系统异常");
        }
        return result;
    }

    /**
     * @date: 2019/5/27
     * @param: [eCooperateMer]
     * @return: com.boot3.com.alibabacloud.commons.response.Result
     * @description: 创建线程查询列表
     */
    @RequestMapping(value = ZCloud3Constants.CLOUD3 + "/queryECooperateMerListPage",
            method = {RequestMethod.POST, RequestMethod.GET})
    public String queryECooperateMerListPage(ECooperateMer eCooperateMer, ModelMap model) throws InterruptedException {
        String sessionID = request.getSession(true).getId();
        request.getSession().setMaxInactiveInterval(1000 * 60 * 30);
        logger.info("=================sessionID:" + sessionID + "====================");
        Cookie cookie = new Cookie("cookie1", "value1");
        response.addCookie(cookie);
        //Thread currentThread = Thread.currentThread();
        //synchronized (currentThread) {
        //    currentThread.wait(2);
        //}
        Result result = new Result();
        try {
            //创建线程执行任务
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        eCooperateMerService.queryECooperateMerListPage(eCooperateMer);
                    } catch (Exception e) {
                        logger.error("系统异常", e);
                        return;
                    }
                }
            };
            //创建线程池
            ExecutorService executorService = Executors.newFixedThreadPool(25);
            for (int i = 0; i < ZCloud3Constants.NUMBER_100; i++) {
                executorService.submit(runnable);
            }
            QueryECooperateMerResponse response = eCooperateMerService.queryECooperateMerListPage(eCooperateMer);
            model.put("eCooperateMerList", response.geteCooperateMerList());
            //单个对象
            ECooperateMer mer = new ECooperateMer();
            mer.setCooperateMerSeq("EC2019042800000023");
            Optional<ECooperateMer> optDto = Optional.ofNullable(eCooperateMerService.queryECooperateMerInfo(mer));
            if (optDto.isPresent()) {
                model.put("eCooperateMer", optDto.get());
            } else {
                throw new Exception("该eCooperateMer不存在");
            }
            result.setResultCode(ZCloud3Constants.RESULT_SUCCESS);
            result.setResultData(model);
        } catch (Exception e) {
            logger.error("系统异常", e);
            result.setResultCode(ZCloud3Constants.RESULT_FAIL);
            result.setResultMessage("系统异常");
        }
        return "e_cooperate_mer_list_page";
    }

}
