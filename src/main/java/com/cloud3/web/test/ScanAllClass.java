package com.cloud3.web.test;

/**
 * @author: HeYongLiu
 * @create: 09-16-2019
 * @description:
 **/
public class ScanAllClass {

    //@RequestMapping(value = "/scanAllClass1", method = RequestMethod.POST)
    //private void scanAnnoPackage(String pkgName) throws CoreException {
    //    log.debug("=======================pkgName" + pkgName);
    //    //获取指定的包的实际路径url，
    //    String surl = this.getClass().getClassLoader().getResource("/").getPath() + pkgName.replaceAll("\\.", "/");
    //    //转化成file对象
    //    File dir = new File(surl);
    //    log.debug("=======================surl" + surl);
    //    //递归查询所有的class文件
    //    for (File file : dir.listFiles()) {
    //        //如果是目录，就递归目录的下一层
    //        if (file.isDirectory()) {
    //            scanAnnoPackage(pkgName + "." + file.getName());
    //        } else {
    //            //如果是class文件，并且是需要被spring托管的
    //            if (!file.getName().endsWith(".class")) {
    //                continue;
    //            }
    //            //举例，className = com.tianyalei.mvc.controller.WebController
    //            String className = pkgName + "." + file.getName().replace(".class", "");
    //            log.debug("=======================className" + className);
    //            //判断是否被Controller或者Service注解了，如果没注解，那么我们就不管它，譬如annotation包和DispatcherServlet类我们就不处理
    //            try {
    //                Class<?> clazz = Class.forName(className);
    //                // 获取方法上的注解
    //                Method[] methods = clazz.getDeclaredMethods();
    //                for (Method method : methods) {
    //                    if (method.isAnnotationPresent(BeeAnnotation.class)) {
    //                        //判断是否有方法ID
    //                        if (!StringUtils.isEmpty(method.getAnnotation(BeeAnnotation.class).methodID())) {
    //                            log.debug("=======================method.getAnnotation(BeeAnnotation.class).methodID()" + method.getAnnotation(BeeAnnotation.class).methodID());
    //                            //添加方法
    //                            com.bee.api.dto.adress.Method addMethod = new com.bee.api.dto.adress.Method();
    //                            addMethod.setMethodId(method.getAnnotation(BeeAnnotation.class).methodID());
    //                            if (!StringUtils.isEmpty(method.getAnnotation(BeeAnnotation.class).methodName())) {
    //                                addMethod.setMethodName(method.getAnnotation(BeeAnnotation.class).methodName());
    //                            } else {
    //                                addMethod.setMethodName(method.getName());
    //                            }
    //                            addMethod.setMethodType(method.getAnnotation(BeeAnnotation.class).methodType());
    //                            addMethod.setMethodIntroduce(method.getAnnotation(BeeAnnotation.class).explain());
    //                            addMethod.setMethodUrl(method.getAnnotation(RequestMapping.class).value()[0].toString());
    //                            addMethod.setRequestExample(method.getAnnotation(BeeAnnotation.class).requestExample());
    //                            addMethod.setReturnExample(method.getAnnotation(BeeAnnotation.class).returnExample());
    //                            addMethod.setRemarks(method.getAnnotation(BeeAnnotation.class).remarks());
    //                            methodService.addMethod(addMethod);
    //                            //添加入参参数
    //                            if (method.getAnnotation(BeeRequestParams.class).value().length > 0) {
    //                                for (BeeRequestParam beeRequestParam : method.getAnnotation(BeeRequestParams.class).value()) {
    //                                    Parameter Parameter = new Parameter();
    //                                    Parameter.setParameterType("1");
    //                                    Parameter.setMethodId(method.getAnnotation(BeeAnnotation.class).methodID());
    //                                    Parameter.setIsAllowNull(beeRequestParam.isAllowNull().equals(Constants.STR_TRUE) ? "1" : "0");
    //                                    Parameter.setParameterIntroduce(beeRequestParam.explain());
    //                                    Parameter.setParameterDataType(beeRequestParam.type());
    //                                    Parameter.setParameterName(beeRequestParam.value());
    //                                    parameterService.insert(Parameter);
    //                                }
    //                            }
    //                            //添加出参参数
    //                            if (method.getAnnotation(BeeResponseParams.class).value().length > 0) {
    //                                for (BeeResponseParam beeResponseParam : method.getAnnotation(BeeResponseParams.class).value()) {
    //                                    Parameter Parameter = new Parameter();
    //                                    Parameter.setParameterType("0");
    //                                    Parameter.setMethodId(method.getAnnotation(BeeAnnotation.class).methodID());
    //                                    Parameter.setParameterIntroduce(beeResponseParam.explain());
    //                                    Parameter.setParameterDataType(beeResponseParam.type());
    //                                    Parameter.setParameterName(beeResponseParam.value());
    //                                    parameterService.insert(Parameter);
    //                                }
    //                            }
    //                        } else {
    //                            throw new CoreException(method.getName() + "有问题");
    //                        }
    //                    }
    //
    //                }
    //            } catch (ClassNotFoundException e) {
    //                e.printStackTrace();
    //            }
    //        }
    //    }
    //}

}
