# SpringBoot actuator端点
/health
作用：健康检查，检查应用资源
status取值有四种
* UP：正常
* DOWN: 遇到问题了，不正常
* OUT_OF_SERVICE：资源未在使用，或者不该去使用
* UNKNOWN：不知道状态是什么

/info
是一个描述应用端点，不是监测端点