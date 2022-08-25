# SMBMSpro1




# JAVAWEB 学习日志 7.30

动态WEB

技术栈：Servlet/Jsp,ASP,PHP

java中，动态web资源开发的技术统称为javaweb



web应用程序

web应用程序：可以提供浏览器访问程序；

通过web服务器映射端口与ip给外界访问

Tomcat、apache、nginx等web服务

tomcat 环境下载

[Apache Tomcat® - Welcome!](https://tomcat.apache.org/)

不建议下载10版本apache（版本10有变动）



一个web服务由多个部分组成（静态web、动态web）

- html，css，js
- jsp，servlet
- java程序
- jar包
- 配置文件（properties）

# 静态web

- \*.htm、\*.html,通过访问服务器请求(request)资源，服务器响应(response)资源
- 用户看到的都是同一个界面
- Javascript
- Vbscript
- 无法和数据库交互（无法持久化，用户无法交互）

# 动态web

- 页面会动态展示：web的页面每个人界面不一样
- webserver plugin 用户接入请求，通过webserver服务返回用户需要的数据
- 连接数据库交互(JDBC) ，数据持久化



# web编程

ASP 

1.微软HTML嵌入VB脚本，

2.ASP+COM    

3.C# IIS服务器

PHP

1.PHP开发速度快，功能强大，跨平台，代码简单

2.无法承载大访问量

JSP

1.B/S浏览器服务器

2.高可用、高并发、高性能

3.基于java语言



# web服务器

IIS

- ASP Windows

Tomcat

- Jsp和Servlet



# Tomcat

 根目录

- bin 运行文件
- conf 配置文件
- lib 依赖文件
- logs 日志
- webapps  网站发布的文件

默认端口8080  配置文件server.xml

设置虚拟目录 `<Host>` 下加

```
<Context path=""  docBase="E:\Administrator\desktop\study\JAVAstu\webDemo\src\main\webapp" >
</Context>
```


webapps 文件下一个文件夹代表一个web应用

在发布目录下配置WEB-INF/web.xml

/WEB-INF/web.xml：Web应用程序配置文件，描述了 servlet 和其他的应用组件配置及命名规则。

/WEB-INF/classes/：包含所有的 Servlet 类和其他类文件，类文件所在的目录结构与他们的包名称匹配。

/WEB-INF/lib/：存放web应用需要的各种JAR文件，放置仅在这个应用中要求使用的jar文件,如数据库驱动jar文件

/WEB-INF/src/：源码目录，按照包名结构放置各个java文件。

/WEB-INF/database.properties：数据库配置文件。

- index.html 默认首页

- 静态网站资源

  - css

  - js

  - img

    ......







HTTP请求

客户端 ->发送请求（Request）-> 服务器

- 地址
- method方法
- 状态码
- 远程IP地址:端口

请求行

Method：POST、GET

消息头

accept：支持的数据类型

accept-encoding:支持的编码格式

accept-Language:支持的语言环境

cache-control:缓存控制

connection:连接





HTTP响应(Response)

- 缓存控制
- 连接类型
- 编码
- 类型

响应体

accept：支持的数据类型

accept-encoding:支持的编码格式

accept-Language:支持的语言环境

cache-control:缓存控制

connection:连接

refresh:刷新间隔

Location：重定向

响应状态码

2xx 请求成功

4xx 客户端错误

3xx 请求重定向

5xx 服务器错误



# Maven 项目架构管理工具

核心：约定大于配置

- 有约定，不去违反

[Maven – Download Apache Maven](https://maven.apache.org/download.cgi)

settings.xml

Maven镜像

```
<mirror>
	<id>alimaven</id>
	<name>aliyun maven</name>
	<url>http://maven.aliyun.com/nexus/content/groups/public</url>
	<mirrorOf>central</mirrorOf>
</mirror>
```

本地仓库

> <localRepository>D:\Maven\repository</localRepository>



选择file->new project..->Maven Archetype -> Archetype  (webapp)

> 创建webapp模板

设置project Structure 项目架构

> 添加sources文件夹和Resource文件夹

设置运行环境Run/Debug Configurations

> 添加local Tomcat
> 并指定文件夹虚拟目录映射



Error

AJP Connector node not found: set up one in the server.xml

需要把Run/Debug Configurations->AJP port设置为空 (HTTPS端口)



Maven Project

Lifecycle   命令行操作

Plugins   插件

Dependencies 项目依赖jar包



pom.xml

`POM` 即 `Project Object Model`,中文名叫 `项目对象模型`。

`pom.xml`文件中声明了当前`项目的坐标`，`引入的依赖`，`打包的方式`，以及`maven管理使用到的插件`等配置信息，是maven项目的`核心配置文件`。

1.groupId 、artifactId 、version 三个元素生成了一个 Maven 项目的基本坐标，在众多的maven 项 目中可以唯一定位到某一个项目

2.坐标也决定着将来项目在仓库中的路径及名称。



 ```
<groupId>com.northcastle</groupId> //组织名称，代码。公司、团体或单位的标识。
<artifactId>HelloWorld</artifactId> //项目名称，如果groupId中有项目名称了，则此处是子项目名称。
<version>1.0-SNAPSHOT</version> //项目的版本号
 <packaging>war</packaging>  //项目的打包方式 jar：java应用 war：javaweb应用
 

 <properties>
  <!--项目的默认构建编码-->
 <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
 <!--编码版本-->
<maven.compiler.source>1.7</maven.compiler.source>
 <maven.compiler.target>1.7</maven.compiler.target>
 </properties>
 ```







[Maven中央仓库JAR包搜索](https://mvnrepository.com)

搜索需要的jar包直接复制jar包坐标到pom.xml文件中

*<!-- 当前项目中引入的依赖的gav -->*

```
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
 <!--项目依赖 的jar包-->
 <dependency>
 <groupId>org.springframework</groupId>
 <artifactId>spring-context</artifactId>
 <version>5.3.22</version>
 </dependency>

```

Maven也会导入这个Jar包的其他依赖

没有自动下载可以手动刷新一下

Maven可以查看Jar包架构体系



Maven由于约定大于配置，java文件夹下只能写java如果写了其他配置文件可能无法导出或生效的情况

在pom.xml文件中build配置Resources，防止资源导出失败问题

```xml
<build>
    <resources>
        <resource>
            <directory>src/main/resources</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
        <resource>
            <directory>src/main/java</directory>
            <includes>
                <include>**/*.properties</include>
                <include>**/*.xml</include>
            </includes>
            <filtering>true</filtering>
        </resource>
    </resources>
</build>
```



alt + enter 可在class文件导入Maven本地仓库的jar包 不存在去mavenrepository中寻找



# Servlet

- Servlet简介

  - servlet就是sun公司开发的动态web的一门技术
  - sun在这些api中提供一个接口叫做Servlet，想要开发Servlet程序，需要：
  - 编写一个类 继承HttpServlet 接口
  - 开发好的java类部署到web服务器中
    - 实现了Servlet接口的java程序叫做Servlet

- servlet配置

  - 构建一个Maven项目

  - 删除src目录，pom.xml文件中添加依赖

  - 另外新建Module ，父子工程在各pom文件中体现

    ``` 
     <parent>
            <artifactId>Servletdemo01</artifactId>
            <groupId>org.Slzr</groupId>
            <version>1.0-SNAPSHOT</version>
        </parent>
    ```

    ``` 
    <modules>
    <module>web</module>
    </modules>
    ```

  - 父项目可以使用子项目

  

  ## WEB.xml 

  

  - web.xml文件的用于配置 欢迎页、Servlet 以及 Filter 等。web.xml 的模式(Schema) 中定义的标签元素才能够使用，根元素<web-app>中，都必须标明这个web.xml使用的是哪个模式文件

  1.xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"

    - 声明 XML Schema 实例，声明后就可以使用schemaLocation属性

  2. xmlns="http://xmlns.jcp.org/xml/ns/javaee"

    - 声明xml文件默认的命名空间，表示未使用其他命名空间的所有标签的默认命名空间。

  3. xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee 		          	http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"

    - 指定Schema的位置这个属性必须结合命名空间使用。这个属性有两个值，第一个值表示需要使用的命名空间。第二个值表示供命名空间使用的XML schema文件。

  4.具体使用什么版本，可以从 http://www.oracle.com/webfolder/technetwork/jsc/xml/ns/javaee/index.html#8 中查到，Java 1.6 及以下版本 命名空间是 http://java.sun.com/xml/ns/javaee ， 1.7及以上命名空间为：http://xmlns.jcp.org/xml/ns/javaee

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
  xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
    http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
  version="4.0"
  metadata-complete="true">
</web-app>

```

使用JSP动态页面 servlet 需要配置web.xml

```xml
<!--请求映射 web.xml配置web核心应用-->
<!--注册servlet-->
<servlet>
    <servlet-name>HelloServlet</servlet-name>
    <servlet-class>HelloServlet</servlet-class>
</servlet>
    <!--一个servlet对应一个Mapping：映射-->
    <servlet-mapping>
        <servlet-name>HelloServlet</servlet-name>
        <!--请求路径  相当于虚拟目录路径-->
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
```



web.xml下

<servlet>标签表示class的具体类

<servlet-mapping>标签表示类对应的映射路径、映射路径可以有多个、也可自定义后缀

优先级原则指定了固有映射路径优先级最高，如果找不到走默认的处理请求

```xml
<!--初始化参数-->
<context-param>
    <param-name></param-name>
    <param-value></param-value>
</context-param>

<servlet>
    <servlet-name>Hello01</servlet-name>
    <servlet-class>com.Slzr.servlet.Servlet01</servlet-class>
</servlet>
    <servlet-mapping>
        <servlet-name>Hello01</servlet-name>
        <url-pattern>/hello</url-pattern>
    </servlet-mapping>
<servlet>
    <servlet-name>error</servlet-name>
    <servlet-class>com.Slzr.servlet.Error</servlet-class>
</servlet>
<servlet-mapping>
    <servlet-name>error</servlet-name>
    <url-pattern>/*</url-pattern>
</servlet-mapping>
```



Servlet 接口 有两个默认的实现类：HttpServlet 、GenericServlet 

HttpServlet继承GenericServlet继承Servlet  

IDEA配置tomcat，首先需要有tomcat的环境目录，设置运行环境Run/Debug Configurations，添加tomcat server [local] ，设置项目发布路径

- Servlet原理
  - web请求Servlet容器，将创建一个servlet对象实例，servlet容器会解析请求并封装为HttpServletrequest对象传入Servlet实例，Servlet处理返回生成一个HttpServletresponse对象传回Servlet容器，Servlet容器解析为Http响应发送给客户端
  - Servlet容器也叫做Servlet引擎，是Web服务器或应用程序服务器的一部分，用于在发送的请求和响应之上提供网络服务，解码基于MIME的请求，格式化基于MIME的响应。
    - 常用的MIME类型：text/html，application/pdf，video/quicktime，application /java，image/jpeg，application/jar，application/octet-stream，application/x- zip）
  - 通信支持: 利用容器提供的方法，你能轻松的让servlet与web服务器对话，而不用自己建立serversocket、监听某个端口、创建流等
  - 多线程支持：容器会自动为它所接收的每个servlet请求创建一个新的java线程。
  - 声明方式实现安全：利用servlet容器，你可以使用xml部署描述文件来配置和修改安全性，而不必将其硬编码写到servlet类代码中。
  - JSP支持：servlet容器负责将jsp代码翻译为真正的java代码。



Java servlet 从3.1版本支持了使用注解开发

- ServletContext类

  - this.getServletContext() 可在不同页面间传递参数共享数据

  ServletContext官方叫servlet上下文。服务器会为每一个工程创建一个对象，这个对象就是ServletContext对象。这个对象全局唯一，而且工程内部的所有servlet都共享这个对象。所以叫全局应用程序共享对象。

``` java
public class Cs1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //通过request获取
        ServletContext servletContext1 = req.getServletContext();
        //通过session对象获取
        ServletContext servletContext2 = req.getSession().getServletContext();
        //通过ServletConfig对象获取
        ServletContext servletContext3 = getServletConfig().getServletContext();
        //直接获取
        ServletContext servletContext = getServletContext();

        //常用方法
        //1. 获取当前服务器的版本信息
        String serverInfo = req.getServletContext().getServerInfo();
        System.out.println("获取当前服务器的版本信息：" + serverInfo);
        //2. 获取项目的真实路径
        String realPath = req.getServletContext().getRealPath("/");
        System.out.println("获取项目的真实路径: " + realPath);


        //获取ServletContext对象
        ServletContext servletContext = req.getServletContext();
        //设置域对象
        servletContext.setAttribute("name","zhangsan");
        //获取域对象
        String name = (String) servletContext.getAttribute("name");
        //移除域对象
        servletContext.removeAttribute("name");
    }
}
```

- service方法：可以处理get/post方式的请求，如果servlet中有service方法，会优先调用service方法
- doGet方法: 处理get方法的请求
- doPost方法: 处理post方式的请求
- 注意：如果在覆写的service方法中调用了父类的service方法 super.service(arg0, arg1);
  则service方法处理完后，会再次根据请求方式响应的doGet和doPost方法执行



Servlet的三大域对象

1. request域对象
   在一次请求中有效，请求转发有效，重定向失效

   request 域对象的生命周期从客户端向容器发送请求开始，到对这次请求做出响应后结束。

   request 域对象只对本次请求涉及的 Servlet 有效。

   由于 Servlet 能处理多个请求，因此 Web 应用中的每个 Servlet 实例都可以有多个 request 域对象。

   Request 域对象需要与请求转发配合使用才能实现动态资源之间的数据共享。

   response.setAttribute(String name, Object o)

   request.getAttribute(String name)

   removeAttribute(String name)

2. session域对象
   在一次会话中有效，请求转发和重定向都有效，session销毁后失效

   - Cookie是将会话状态保存在了客户端
     - Cookie [] cookies= req.getCookies();
     - resp.addCookie(new Cookie("key","value"));
   - Session是将会话状态保存在了服务端
     - HttpSession session=request.getSession();
     - setAttribute(String name, Object o)；
     - getAttribute(String name)；
     - removeAttribute(String name)

3. servletContext 域对象

   Context 域对象的生命周期从容器启动开始，到容器关闭或者 Web 应用被移除时结束；

   Context 域对象对整个 Web 应用内的所有Servlet都有效；

   Context 域对象可以独立完成动态资源之间的数据共享；

   整个 Web 应用中只有一个 Context 域对象；

**重定向**——`sendRedirect("URL")`

```java
//重定向会将请求地址转到重定向地址，请求地址会改变，并显示重定向地址的响应结果，客户端行为
HttpServletResponse resp;
resp.sendRedirect("/重定向url");
```



**请求转发**——`getRequestDispatcher("URL").forward(req,resp)`

```java
//请求转发不会发生请求地址的改变，在当前地址得到转发地址的响应结果，服务器行为
ServletContext context = this.getServletContext();//servlet上下文，全局配置
context.getRequestDispatcher("/请求转发指定url").forward(req,resp);
```





读取资源文件

```properties
username=root
password=123456
```

```java
//读取资源配置文件
InputStream is= this.getServletContext().getResourceAsStream("/WEB-INF/classes/com/Slzr/demo02/jdbc.properties");
Properties properties = new Properties();
//加载流文件
properties.load(is);
String username=properties.getProperty("username");
```

```jsp
<%
    InputStream is= request.getServletContext().getResourceAsStream("/WEB-INF/classes/db.properties");
    Properties ppt=new Properties();
    ppt.load(is);
    String value=ppt.toString();
    Set<Object> so=ppt.keySet();
    Map<String,String> ms=new HashMap<>();
    for (Object keyo:so){
    String key=keyo.toString();
    value=ppt.getProperty(key);
    ms.put(key,value);

%>
        <%=key%> <%=value%>
<%

    }
//存入Servlet上下文的属性中
    request.getServletContext().setAttribute("ppt",ppt);
%>
```

```java
//获取上下文，获取上下文属性
properties=(Properties)this.getServletContext().getAttribute("ppt");
```

1. `Properties`是继承自`HashTable`的。
2. 直接通过`keySet()`、`keys()`或`entrySet()`方法对Properties中的元素进行遍历时取出来的内容顺序与properties文件中的顺序不一致



# HttpServlet

web服务器响应客户端请求，会创建一个代表请求的HttpServletRequestd对象和代表响应的HttpServletRequest



## HttpServletResponse

向浏览器发送数据

```java
ServletOutputStream getOutPutStreamm()//用于获取字节输出流对象

PrintWriter getWriter() //用于获取字符输出流对象。 
```



## 设置浏览器响应头

```java
void setCharacterEncoding(String var1);
void setContentLength(int var1);
void setContentType(String var1);
void setContentLengthLong(long var1);
void setDateHeader(String var1, long var2);
void setHeader(String var1, String var2);
void setStatus(int var1);
void addDateHeader(String var1, long var2);
void addIntHeader(String var1, int var2);
void addCookie(Cookie var1);
void addHeader(String var1, String var2);
```



响应常量状态码

```java
int SC_OK = 200;
 int SC_NOT_FOUND = 404;
int SC_INTERNAL_SERVER_ERROR = 500;
int SC_MOVED_TEMPORARILY = 302;
```



## HttpServletRequest

```java
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setCharacterEncoding("utf-8");
        System.out.println("requestTest请求"+req.getParameter("user")+":"+req.getParameter("pwd"));
        req.getRequestDispatcher("/success.jsp").forward(req,resp);
    }
```



![Servlet 处理HTTP请求](http://c.biancheng.net/uploads/allimg/210627/1103524464-0.png)



```java
HttpServletRequest类
getMethod() //获取请求方式

getParameter(String name) //获取form表单值

getHeader(String name)  //获取头字段的值

getServletPath()  //该方法用于获取 Servlet 所映射的路径。
setAttribute(String name, Object o)//将 Java 对象与属性名绑定，并将它作为一个属性存放到 request 对象中。参数 name 为属性名，参数 object 为属性值。
getAttribute(String name) //根据属性名 name，返回 request 中对应的属性值。
```







Servlet 文件下载

```java
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
     //获取绝对路径
        String path=  this.getServletContext().getRealPath("/WEB-INF/classes/1.jpeg");
        //获取文件名
    String sub= path.substring(path.lastIndexOf("\\")+1);
        System.out.println(path);
        System.out.println(sub);
        //设置响应的信息头为附件
        resp.setHeader("Content-disposition","attachment;filename="+sub);
        //读取文件流
        FileInputStream input = new FileInputStream(path);
        //创建缓存区
        int len=0;
        byte [] bytes=new byte[1024];
        //写入文件流
        ServletOutputStream sop=resp.getOutputStream();
        //写入缓存区 ,并使用OutputStream输入到客户端
        while ((len=input.read(bytes))>0){
            sop.write(bytes,0,len);
        }
        sop.close();
        input.close();

    }
```



验证码

```java
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //浏览器刷新时间
        resp.setHeader("refresh","3");
        //缓存中创建图片
        BufferedImage bi= new BufferedImage(80,20,BufferedImage.TYPE_3BYTE_BGR );
        //获得图片  画笔
        Graphics2D gi=(Graphics2D)bi.getGraphics();
       //设置背景颜色
        gi.setColor(Color.white);
        gi.fillRect(0,0,80,20);
        //写入字体
        gi.setColor(Color.BLACK);
        gi.setFont(new Font(null, Font.BOLD,20));
        gi.drawString(makenum(),0,20);
        //请求格式
        resp.setContentType("image/jpeg");
        //关闭网站缓存
        resp.setDateHeader("expires",-1);
        resp.setHeader("Cache-Control","no-cache");
        resp.setHeader("Pragma","no-cache");
        //图片输入到浏览器
        ImageIO.write(bi,"jpeg",resp.getOutputStream());

    }
    private String makenum(){
        Random random=new Random();
        String num=random.nextInt(9999)+"";
        //保证获取随机数为四位数
        StringBuffer strb=new StringBuffer();
        for (int i = 0; i < 4-num.length(); i++) {
            strb.append("0");
        }
       return (strb.reverse()).toString()+num;
    }
```



## Cookie

```java 
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter(); //out为printwriter的内置对象 Writer out;
        Cookie [] cookies= req.getCookies();//获得cookie数组
        String lastTime=null;
        if (cookies!=null){
            for(int i=0;i<cookies.length;i++){
                if("lastTime".equals(cookies[i].getName())){//获得cookie键
                lastTime=cookies[i].getValue();//获得cookie值
				Date date=new Date(Long.parseLong(lastTime));
                out.print(DateFormat.getDateInstance().format(date));
                }
            }
        }
        if(lastTime==null){
            out.print("第一次登录");
        }
        Cookie co=new Cookie("lastTime", System.currentTimeMillis()+"");//创建cookie
    	co.setMaxAge(24*60*60);//设置cookie有效期
        resp.addCookie(co);//发送cookie
    }

```

cookie：存放于用户缓存目录下 appdate；

一个cookie只能保存一个信息

一个web站点可以给浏览器发送更多cookie，最多20个

cookie大小限制为4kb；

300个cookie为浏览器上限

删除cookie；

不设置有效期或设置有效期为0



# 乱码问题

字节流输出中文是否出现乱码，取决于中文转成字节数组时与浏览器打开时采用的字符集是否一致

request 对象接收到数据之后，会将数据放到 request 缓冲区，缓冲区的默认字符集是 ISO-8859-1（该字符集不支持中文），两者使用的字符集不一致导致乱码。

```
URLEncoder.encode(String s, String enc);//在网络编程中可能需要进行转码操作
URLDecoder.decode(String s, String enc);//在网络编程中可能需要进行解码操作
String(byte[] bytes, String charset)  //使用 String 的构造方法对字节数组（bytes）按照指定的字符集（charset）进行解码
```

newCookie.setPath（“/”）; //设置cookie路径,项目所有目录均有效，不设置默认在servlet的url-pattern路径下

## Session

```java
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession hs =req.getSession();
        if(hs.isNew()){
            resp.getWriter().write("创建session成功");
            hs.setAttribute("name","session");
        }else{
            resp.getWriter().write("已经存在session："+hs.getId());
        }
    }
```

- request.getSession().setMaxInactiveInterval(100); //设置过期时间，以秒为单位，零和负数表示会话永远不会过期

# Filter

```java
init (FilterConfig filterConfig);//该方法用于初始化过滤器。
doFilter(ServletRequest request,SeivletResponse response, FilterChain chain);/*该方法完成实际的过滤操作，当客户端请求的 URL 与过滤器映射的 URL 匹配时，容器会先调用该方法对请求进行拦截。
参数 request 和 response 表示请求和响应对象。
参数 chain 代表当前 Filter 链对象，在该方法内部，调用 chain.doFilter() 方法，才能把请求交付给 Filter 链中的下一个 Filter 或者 Web 资源。*/
destroy();//该方法在销毁 Filter 对象之前被调用，用于释放被 Filter 对象占用的资源。
chain.doFilter(request, response);//返回响应资源
```

web.xml 注册Filter

```xml
<filter>
    <filter-name>myFilter</filter-name>
    <filter-class>com.Slzr.myFilter</filter-class>
    <init-param>
        <param-name>Filter</param-name> <!---传递到init方法中-->
        <param-value>过滤器</param-value>
    </init-param>
   
</filter>

<filter-mapping>
    <filter-name>myFilter</filter-name>
    <url-pattern>/source</url-pattern>   <!--拦截请求路径-->
    <dispatcher>REQUEST</dispatcher>
    <dispatcher>FORWARD</dispatcher>
</filter-mapping>
<filter-mapping>
    <filter-name>myFilter</filter-name>
    <servlet-name>ServletDemo</servlet-name><!--拦截的 Servlet 名称-->
</filter-mapping>
```

```java
@WebFilter(
        dispatcherTypes = {
                DispatcherType.REQUEST,
                DispatcherType.FORWARD,
                DispatcherType.INCLUDE,
                DispatcherType.ERROR
        },
        asyncSupported = true, //asyncSupported 声明过滤器是否支持异步操作模式
        description = "过滤器4",
        urlPatterns = {"/login"},
     	initParams = {
                @WebInitParam(name = "name", value = "name", description = "name的描述")
        },
        servletNames = {"SuccessServlet"})
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {//拦截请求 处理操作和任务 chain.doFilter(request, response);传递页面请求响应给下一个filter或webservlet资源
    }
}
```



<dispatcher> 元素的取值及其意义：

- REQUEST：当用户直接访问页面时，容器将会调用过滤器。如果目标资源是通过 RequestDispatcher 的 include() 或 forward() 方法访问，则该过滤器就不会被调用。

- INCLUDE：如果目标资源通过 RequestDispatcher 的 include() 方法访问，则该过滤器将被调用。除此之外，该过滤器不会被调用。

- FORWARD：如果目标资源通过 RequestDispatcher 的 forward() 方法访问，则该过滤器将被调用，除此之外，该过滤器不会被调用。

- ERROR：如果目标资源通过声明式异常处理机制访问，则该过滤器将被调用。除此之外，过滤器不会被调用。

  

## Filter 链

不建议使用servlet注解

过滤器链中的任何一个 Filter 没有调用 FilterChain.doFilter() 方法，请求都不会到达目标资源。

通过 web.xml 配置的 Filter 过滤器，执行顺序由 <filter-mapping> 标签的配置顺序决定。<filter-mapping> 靠前，则 Filter 先执行，靠后则后执行。通过修改 <filter-mapping> 的顺序便可以修改 Filter 的执行顺序。

过滤器链中的任何一个 Filter 没有调用 FilterChain.doFilter() 方法，请求都不会到达目标资源。



## FilterConfig 

```java
getInitParameterNames();//返回过滤器的所有初始化参数名的枚举集合。
getInitParameter(String name);//根据初始化参数名 name，返回对应的初始化参数值。
getServletContext();//返回 Servlet 上下文对象的引用。
```



# 监听器 Listener

Servlet 规范中定义了 8 个监听器接口，可以用于监听 ServletContext、HttpSession 和 ServletRequest 对象的生命周期和属性变化事件。开发 Servlet 监听器需要实现相应的监听器接口并重写接口中的方法。

web.xml  Listenerr注册

```java
<listener>
        <listener-class>com.Slzr.Listenername</listener-class>
    </listener>
```

```java
@WebListener   //注解注册监听器
public class MyListener implements ServletContextListener {//继承监听servletcontext上下文类
    public MyListener() {
    }
    public void contextDestroyed(ServletContextEvent sce) {//监听servletcontext对象创建
    }
    public void contextInitialized(ServletContextEvent sce) {//监听servletcontext对象销毁
    }
}
```





继承接口类 实现方法

```java
ServletContextListener;//监听 ServletContext 对象的创建与销毁过程
HttpSessionListener;//监听 HttpSession 对象的创建和销毁过程
ServletRequestListener;//监听 ServletRequest 对象的创建和销毁过程
ServletContextAttributeListener//用于监听 ServletContext 对象的属性新增、移除和替换 
HttpSessionAttributeListener//用于监听 HttpSession 对象的属性新增、移除和替换
ServletRequestAttributeListener//用于监听 HttpServletRequest 对象的属性新增、移除和替换
HttpSessionBindingListener//用于监听 JavaBean 对象绑定到 HttpSession 对象和从 HttpSession 对象解绑的事件
HttpSessionActivationListener//监听 HttpSession 中对象活化和钝化的过程    
```

[Servlet监听器统计网站在线人数 (biancheng.net)](http://c.biancheng.net/servlet2/user-online.html)



# Servlet注解



为了简化 Servlet 的配置，Servlet 3.0 中增加了注解支持，例如：@WebServlet、@WebInitParm 、@WebFilter 和 @WebLitener 等

web.xml配置文件中设置 metadata-complete=" 'boolean' "  true表示关闭注解 false表示开启注解

- 通过实现 Serlvet 接口或继承 GenericServlet 创建的 Servlet 类无法使用 @WebServlet 注解。
- 使用 @WebServlet 注解配置的 Servlet 类，不要在 web.xml 文件中再次配置该 Servlet 相关属性。若同时使用 web.xml 与 @WebServlet 配置同一 Servlet 类，则 web.xml 中 <servlet-name> 的值与注解中 name 取值不能相同，否则容器会忽略注解中的配置。

```java
@WebServlet(name = "servlet1",value = "/servlet1")
```





# JSP

jsp网页编译的文件会在C:\Users\Administrator\AppData\Local\JetBrains\IntelliJIdea2022.1\tomcat\目录下的项目的work文件夹里

jsp本身是一个servlet 

包含通用的内置对象

```java
final javax.servlet.jsp.PageContext pageContext;//保存的数据只在一个页面有效
javax.servlet.http.HttpSession session = null;//保存的数据只在一个浏览器会话有效
final javax.servlet.ServletContext application;//保存的数据在一个web服务中有效
final javax.servlet.ServletConfig config;
javax.servlet.jsp.JspWriter out = null;
final java.lang.Object page = this;
final javax.servlet.http.HttpServletRequest request;//保存的数据在一次请求有效
final javax.servlet.http.HttpServletResponse response;
 exception
```

每次输出会重新编译jsp为class文件

所以有高耦合性，前后端不分离

```jsp
<%=变量%><!--jsp表达式   作用域局部-->

<%%><!--片段 _jspService方法中实现  作用域局部-->

<%! %><!--jsp声明 编译到java类中实现 作用域全局-->

<%@ %><!--自定义页面  属性-->

${} <!--EL表达式-->
<!--错误或不显示需要更新web.xml version
EL表达式可以直接以键取出对象里的值-->
<%application.setAttribute("name","lzr");%>
<%String a= (String) pageContext.findAttribute("name");%>
<!--寻找数值会从底层到高层寻找 page->request->session->application 找不到返回null-->
<!--JVM找依赖包类似 双亲委派机制-->
<h1> ${name} </h1>
<h1><%=a%></h1>
<%@include %> <!--包含-->

```

JSP标签

```jsp
<jsp:forward page="">

<jsp:parm name="" value=""></jsp:faram>

</jsp:forward >
```





# JSTL

JSTL标签库

需要导依赖包包

```xml
<!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
<!-- https://mvnrepository.com/artifact/taglibs/standard -->
<dependency>
    <groupId>taglibs</groupId>
    <artifactId>standard</artifactId>
    <version>1.1.2</version>
</dependency>
<!--使用JSTL和EL表达式需要的依赖包-->

```

jap页面添加<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> //自定义标签

```jsp
<c:if test="" var=""> <!--判断条件test-->
<c:forEach var="name" items="${value}"><!--循环输出-->
    <c:out value="${name}"></c:out>
</c:forEach>
```



# JavaBean

一般用来做数据库字段映射

ORM：对象关系映射

必须有无惨构造函数、属性、setter和getter



```java
package com.Slzr.entity;

public class People {
    private int id;
    private String name;
    private int age;
    private String address;
    public  People(){}
    public  People(int id,String name,int age,String address){
        this.id=id;
        this.name=name;
        this.age=age;
        this.address=address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "People{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", age=" + age +
            ", address='" + address + '\'' +
            '}';
    }
}
```



```xml
<%
   // People people=new People();
   // people.setAddress("");
%>
<jsp:useBean id="People" class="com.Slzr.entity.People" scope="page"  ></jsp:useBean>
<jsp:setProperty name="People" property="id" value="1"></jsp:setProperty>
<jsp:setProperty name="People" property="age" value="18"></jsp:setProperty>
<jsp:setProperty name="People" property="name" value="lisi"></jsp:setProperty>
<jsp:setProperty name="People" property="address" value="shenyangdajie"></jsp:setProperty>
<P>
<jsp:getProperty name="People" property="id"/>
<jsp:getProperty name="People" property="name"/>
<jsp:getProperty name="People" property="age"/>
<jsp:getProperty name="People" property="address"/>
```



# MVC

模块（MODEL）、视图（VIEW）、控制器（CONTROL）

- 模块
  1. 业务处理：业务逻辑（service）
  2. 数据持久层：CRUD（DAO）利用数据库组件来与数据库交互
  3. 接收控制器发来的数据并进行处理
- 视图
  1. 展示数据
  2. 跳转链接发起请求servlet或提交表单（a,form,img..）
- 控制器
  1. 接收用户的请求：（req：请求参数、session信息..）
  2. 交给业务层处理代码
  3. 控制视图跳转



# MYSQL

JDBC
javadbconnect;

[MySQL :: Download MySQL Community Server](https://dev.mysql.com/downloads/mysql/)

mysql下载链接

windows mysql安装8.0以上版本问题 修改密码出现1045和2003错误

如果之前初始化了mysql服务缺无法启动

首先删除mysql根目录下`data`文件夹 

并且运行 `sc delete mysql`

重新初始化

`mysqld --initlalize-insecure`

自动生成data文件夹

添加`my.ini`文件在根目录下

```ini
[mysql]
default-character-set=utf8
[mysqld]
default-storage-engine=INNODB
#确认mysql安装目录和数据库的存放目录
basedir=C:/Program Files/mysql-8.0.25-winx64
datadir=C:/Program Files/mysql-8.0.25-winx64/data
```

接着运行 `mysqld --install`

此时已经解决2003和服务无法启动的问题

1045是由于密码不正确导致的

重置密码步骤

打开dos命令行窗口

```shell
net stop mysql

mysqld --console --skip-grant-tables --shared-memory
```

运行这个命令后不关闭打开第二个dos命令行窗口

```shell
mysql -u root -p
#无密码登录

use mysql
update user set authentication_string='' where user='root';
quit
```

关闭之前两个窗口，此时密码是空

打开第三个dos命令行窗口

```shell
net start Mysql

mysql -u root -p

ALTER USER 'root'@'localhost' IDENTIFIED BY '123456';
```

密码已修改为123456；

[Windows10安装Mysql 8.0数据库提示服务无法启动的终极解决办法和根本原因_爱因斯坦！的博客-CSDN博客_mysql80服务无法启动解决办法](https://blog.csdn.net/xuexijiaoliu/article/details/122294814)

```xml
<!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
<dependency>
    <groupId>mysql</groupId>
    <artifactId>mysql-connector-java</artifactId>
    <version>8.0.30</version>
</dependency>
```



```mysql
create database `jdbc` collate utf8mb3_general_ci;
create table users
(
    id       int         not null
        primary key,
    `name`     varchar(40) null,
    `password` varchar(40) null,
    email    varchar(40) null,
    birthday date        null
);

```

```java
  String url="jdbc:mysql://localhost:3306/jdbc?" +
                "useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
        String user="root";
        String pwd="123456";
        Class.forName("com.mysql.cj.jdbc.Driver");//反射加载mysql驱动
        Connection connection = DriverManager.getConnection(url, user, pwd);//驱动管理连接数据库 	
        Statement statement = connection.createStatement();//向数据库发送SQL的对象 Statement：CRUD  PreparedStatement安全 防止sql注入但要预编译sql语句
        String sql="select * from users";
        //执行查询sql语句，返回结果集 ,如果需要改变数据需要用到executeupdate
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next()){
            System.out.println(resultSet.getObject("id"));
            System.out.println(resultSet.getObject("name"));
            System.out.println(resultSet.getObject("password"));
            System.out.println(resultSet.getObject("email"));
            System.out.println(resultSet.getObject("birthday"));
        }
        if (resultSet!=null)
        resultSet.close();
        statement.close();//关闭连接释放资源
        connection.close();
```



```xml pom.xml
   <dependency>
<!--单元测试 在方法的上面加@Test 注解-->
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>

    </dependency>
```


```java
 @Test
   public void jdbcconn() throws SQLException, ClassNotFoundException {
       String url="jdbc:mysql://localhost:3306/jdbc?" +
               "useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
       String user="root";
       String pwd="123456";
       Class.forName("com.mysql.cj.jdbc.Driver");
       Connection connection = DriverManager.getConnection(url, user, pwd);
       String sql="insert into users(id,name,password,email,birthday)values (?,?,?,?,?);";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setObject(1,"5");
        preparedStatement.setObject(2,"阿七");
        preparedStatement.setObject(3,"123456");
        preparedStatement.setObject(4,"aq@qq.com");
        preparedStatement.setObject(5,new Date());
        int i = preparedStatement.executeUpdate();
        if(i>0){
            System.out.println("数据增加成功");
        }

        preparedStatement.close();
        connection.close();;
    }
```



## sql事务

ACID，原子性，一致性，隔离性，持久性

开启事务

事务提交 commit();

事务回滚 rollback();

关闭事务

```java
String url="jdbc:mysql://localhost:3306/jdbc?" +
    "useUnicode=true&characterEncoding=utf-8&serverTimezone=UTC";
String user="root";
String pwd="123456";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection connection = DriverManager.getConnection(url, user, pwd);
connection.setAutoCommit(false);//开启事务
String sql="update account set money =money-100 where name ='A';";
String sql2="update account set money =money+100 where name ='B';";
connection.prepareStatement(sql).executeUpdate();//运行事务
connection.prepareStatement(sql2).executeUpdate();
connection.rollback();//回滚
connection.commit();//提交
```



# SMBMS项目练习

新建项目 

添加java 、resources 文件夹

java目录下添加项目结构目录  entity、services、servlet、util、filter、dao

添加tomcat运行环境

导入数据库

```mysql
create database smbms;
use smbms;
create table smbms_bill
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    billCode     varchar(20)    null comment '账单编码',
    productName  varchar(20)    null comment '商品名称',
    productDesc  varchar(50)    null comment '商品描述',
    productUnit  varchar(10)    null comment '商品单位',
    productCount decimal(20, 2) null comment '商品数量',
    totalPrice   decimal(20, 2) null comment '商品总额',
    isPayment    int            null comment '是否支付（1：未支付 2：已支付）',
    createdBy    bigint         null comment '创建者（userId）',
    creationDate datetime       null comment '创建时间',
    modifyBy     bigint         null comment '更新者（userId）',
    modifyDate   datetime       null comment '更新时间',
    providerId   int            null comment '供应商ID'
)
    collate = utf8mb3_unicode_ci;

INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (1, 'BILL2016_001', '洗发水、护发素', '日用品-洗发、护发', '瓶', 500.00, 25000.00, 2, 1, '2014-12-14 13:02:03', 15, '2019-04-16 21:43:12', 13);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (2, 'BILL2016_002', '香皂、肥皂、药皂', '日用品-皂类', '块', 1000.00, 10000.00, 2, 1, '2016-03-23 04:20:40', null, null, 13);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (3, 'BILL2016_003', '大豆油', '食品-食用油', '斤', 300.00, 5890.00, 2, 1, '2014-12-14 13:02:03', null, null, 6);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (4, 'BILL2016_004', '橄榄油', '食品-进口食用油', '斤', 200.00, 9800.00, 2, 1, '2013-10-10 03:12:13', null, null, 7);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (5, 'BILL2016_005', '洗洁精', '日用品-厨房清洁', '瓶', 500.00, 7000.00, 2, 1, '2014-12-14 13:02:03', null, null, 9);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (6, 'BILL2016_006', '美国大杏仁', '食品-坚果', '袋', 300.00, 5000.00, 2, 1, '2016-04-14 06:08:09', null, null, 4);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (7, 'BILL2016_007', '沐浴液、精油', '日用品-沐浴类', '瓶', 500.00, 23000.00, 1, 1, '2016-07-22 10:10:22', null, null, 14);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (8, 'BILL2016_008', '不锈钢盘碗', '日用品-厨房用具', '个', 600.00, 6000.00, 2, 1, '2016-04-14 05:12:13', null, null, 14);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (9, 'BILL2016_009', '塑料杯', '日用品-杯子', '个', 350.00, 1750.00, 2, 1, '2016-02-04 11:40:20', null, null, 14);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (10, 'BILL2016_010', '豆瓣酱', '食品-调料', '瓶', 200.00, 2000.00, 2, 1, '2013-10-29 05:07:03', null, null, 8);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (11, 'BILL2016_011', '海之蓝', '饮料-国酒', '瓶', 50.00, 10000.00, 1, 1, '2016-04-14 16:16:00', null, null, 1);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (12, 'BILL2016_012', '芝华士', '饮料-洋酒', '瓶', 20.00, 6000.00, 1, 1, '2016-09-09 17:00:00', null, null, 1);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (13, 'BILL2016_013', '长城红葡萄酒', '饮料-红酒', '瓶', 60.00, 800.00, 2, 1, '2016-11-14 15:23:00', null, null, 1);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (14, 'BILL2016_014', '泰国香米', '食品-大米', '斤', 400.00, 5000.00, 2, 1, '2016-10-09 15:20:00', null, null, 3);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (15, 'BILL2016_015', '东北大米', '食品-大米', '斤', 600.00, 4000.00, 2, 1, '2016-11-14 14:00:00', null, null, 3);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (16, 'BILL2016_016', '可口可乐', '饮料', '瓶', 2000.00, 6000.00, 2, 1, '2012-03-27 13:03:01', null, null, 2);
INSERT INTO smbms.smbms_bill (id, billCode, productName, productDesc, productUnit, productCount, totalPrice, isPayment, createdBy, creationDate, modifyBy, modifyDate, providerId) VALUES (17, 'BILL2016_017', '脉动', '饮料', '瓶', 1500.00, 4500.00, 2, 1, '2016-05-10 12:00:00', null, null, 2);

create table smbms_provider
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    proCode      varchar(20) null comment '供应商编码',
    proName      varchar(20) null comment '供应商名称',
    proDesc      varchar(50) null comment '供应商详细描述',
    proContact   varchar(20) null comment '供应商联系人',
    proPhone     varchar(20) null comment '联系电话',
    proAddress   varchar(50) null comment '地址',
    proFax       varchar(20) null comment '传真',
    createdBy    bigint      null comment '创建者（userId）',
    creationDate datetime    null comment '创建时间',
    modifyDate   datetime    null comment '更新时间',
    modifyBy     bigint      null comment '更新者（userId）'
)
    collate = utf8mb3_unicode_ci;

INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (1, 'BJ_GYS001', '北京三木堂商贸有限公司', '长期合作伙伴，主营产品:茅台、五粮液、郎酒、酒鬼酒、泸州老窖、赖茅酒、法国红酒等', '张国强', '13566669999', '北京市丰台区育芳园北路', '010-58858787', 1, '2013-03-21 16:52:07', '2019-04-12 16:44:03', 10);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (2, 'HB_GYS001', '石家庄帅益食品贸易有限公司', '长期合作伙伴，主营产品:饮料、水饮料、植物蛋白饮料、休闲食品、果汁饮料、功能饮料等', '王军', '13309094212', '河北省石家庄新华区', '0311-67738876', 1, '2016-04-13 04:20:40', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (3, 'GZ_GYS001', '深圳市泰香米业有限公司', '初次合作伙伴，主营产品：良记金轮米,龙轮香米等', '郑程瀚', '13402013312', '广东省深圳市福田区深南大道6006华丰大厦', '0755-67776212', 1, '2014-03-21 16:56:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (4, 'GZ_GYS002', '深圳市喜来客商贸有限公司', '长期合作伙伴，主营产品：坚果炒货.果脯蜜饯.天然花茶.营养豆豆.特色美食.进口食品.海味零食.肉脯肉', '林妮', '18599897645', '广东省深圳市福龙工业区B2栋3楼西', '0755-67772341', 1, '2013-03-22 16:52:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (5, 'JS_GYS001', '兴化佳美调味品厂', '长期合作伙伴，主营产品：天然香辛料、鸡精、复合调味料', '徐国洋', '13754444221', '江苏省兴化市林湖工业区', '0523-21299098', 1, '2015-11-22 16:52:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (6, 'BJ_GYS002', '北京纳福尔食用油有限公司', '长期合作伙伴，主营产品：山茶油、大豆油、花生油、橄榄油等', '马莺', '13422235678', '北京市朝阳区珠江帝景1号楼', '010-588634233', 1, '2012-03-21 17:52:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (7, 'BJ_GYS003', '北京国粮食用油有限公司', '初次合作伙伴，主营产品：花生油、大豆油、小磨油等', '王驰', '13344441135', '北京大兴青云店开发区', '010-588134111', 1, '2016-04-13 00:00:00', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (8, 'ZJ_GYS001', '慈溪市广和绿色食品厂', '长期合作伙伴，主营产品：豆瓣酱、黄豆酱、甜面酱，辣椒，大蒜等农产品', '薛圣丹', '18099953223', '浙江省宁波市慈溪周巷小安村', '0574-34449090', 1, '2013-11-21 06:02:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (9, 'GX_GYS001', '优百商贸有限公司', '长期合作伙伴，主营产品：日化产品', '李立国', '13323566543', '广西南宁市秀厢大道42-1号', '0771-98861134', 1, '2013-03-21 19:52:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (10, 'JS_GYS002', '南京火头军信息技术有限公司', '长期合作伙伴，主营产品：不锈钢厨具等', '陈女士', '13098992113', '江苏省南京市浦口区浦口大道1号新城总部大厦A座903室', '025-86223345', 1, '2013-03-25 16:52:07', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (11, 'GZ_GYS003', '广州市白云区美星五金制品厂', '长期合作伙伴，主营产品：海绵床垫、坐垫、靠垫、海绵枕头、头枕等', '梁天', '13562276775', '广州市白云区钟落潭镇福龙路20号', '020-85542231', 1, '2016-12-21 06:12:17', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (12, 'BJ_GYS004', '北京隆盛日化科技', '长期合作伙伴，主营产品：日化环保清洗剂，家居洗涤专卖、洗涤用品网、墙体除霉剂、墙面霉菌清除剂等', '孙欣', '13689865678', '北京市大兴区旧宫', '010-35576786', 1, '2014-11-21 12:51:11', null, null);
INSERT INTO smbms.smbms_provider (id, proCode, proName, proDesc, proContact, proPhone, proAddress, proFax, createdBy, creationDate, modifyDate, modifyBy) VALUES (13, 'SD_GYS001', '山东豪克华光联合发展有限公司', '长期合作伙伴，主营产品：洗衣皂、洗衣粉、洗衣液、洗洁精、消杀类、香皂等', '吴洪转', '13245468787', '山东济阳济北工业区仁和街21号', '0531-53362445', 1, '2015-01-28 10:52:07', null, null);

create table smbms_role
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    roleCode     varchar(15) null comment '角色编码',
    roleName     varchar(15) null comment '角色名称',
    createdBy    bigint      null comment '创建者',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '修改者',
    modifyDate   datetime    null comment '修改时间'
)
    collate = utf8mb3_unicode_ci;

INSERT INTO smbms.smbms_role (id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate) VALUES (1, 'SMBMS_ADMIN', '系统管理员', 1, '2016-04-13 00:00:00', null, null);
INSERT INTO smbms.smbms_role (id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate) VALUES (2, 'SMBMS_MANAGER', '经理', 1, '2016-04-13 00:00:00', null, null);
INSERT INTO smbms.smbms_role (id, roleCode, roleName, createdBy, creationDate, modifyBy, modifyDate) VALUES (3, 'SMBMS_EMPLOYEE', '普通员工', 1, '2016-04-13 00:00:00', null, null);

create table smbms_user
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    userCode     varchar(15) null comment '用户编码',
    userName     varchar(15) null comment '用户名称',
    userPassword varchar(15) null comment '用户密码',
    gender       int         null comment '性别（1:女、 2:男）',
    birthday     date        null comment '出生日期',
    phone        varchar(15) null comment '手机',
    address      varchar(30) null comment '地址',
    userRole     int         null comment '用户角色（取自角色表-角色id）',
    createdBy    bigint      null comment '创建者（userId）',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '更新者（userId）',
    modifyDate   datetime    null comment '更新时间'
)
    collate = utf8mb3_unicode_ci;

INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (1, 'admin', '系统管理员', '123456', 1, '1997-01-01', '15200981234', '湖南省衡阳市蒸湘区南华大学', 1, 1, '2019-04-07 10:15:55', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (5, 'hanlubiao', '韩路彪', '0000000', 2, '1984-06-05', '18567542321', '北京市朝阳区北辰中心12号', 2, 1, '2014-12-31 19:52:09', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (6, 'zhanghua', '张华', '0000000', 1, '1983-06-15', '13544561111', '北京市海淀区学院路61号', 3, 1, '2013-02-11 10:51:17', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (7, 'wangyang', '王洋', '0000000', 2, '1982-12-31', '13444561124', '北京市海淀区西二旗辉煌国际16层', 3, 1, '2014-06-11 19:09:07', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (8, 'zhaoyan', '赵燕', '0000000', 1, '1986-03-07', '18098764545', '北京市海淀区回龙观小区10号楼', 3, 1, '2016-04-21 13:54:07', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (10, 'sunlei', '孙磊', '0000000', 2, '1981-01-04', '13387676765', '北京市朝阳区管庄新月小区12楼', 3, 1, '2015-05-06 10:52:07', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (11, 'sunxing', '孙兴', '0000000', 2, '1978-03-12', '13367890900', '北京市朝阳区建国门南大街10号', 3, 1, '2016-11-09 16:51:17', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (12, 'zhangchen', '张晨', '0000000', 1, '1986-03-28', '18098765434', '朝阳区管庄路口北柏林爱乐三期13号楼', 3, 1, '2016-08-09 05:52:37', 1, '2016-04-14 14:15:36');
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (13, 'dengchao', '邓超', '0000000', 2, '1981-11-04', '13689674534', '北京市海淀区北航家属院10号楼', 3, 1, '2016-07-11 08:02:47', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (14, 'yangguo', '杨过', '0000000', 2, '1980-01-01', '13388886623', '北京市朝阳区北苑家园茉莉园20号楼', 3, 1, '2015-02-01 03:52:07', null, null);
INSERT INTO smbms.smbms_user (id, userCode, userName, userPassword, gender, birthday, phone, address, userRole, createdBy, creationDate, modifyBy, modifyDate) VALUES (15, 'test', 'test', '111', 1, '2019-04-16', '123456789', '南华大学', 1, 1, '2019-04-16 19:52:37', null, null);

create table smbms_address
(
    id           bigint auto_increment comment '主键ID'
        primary key,
    contact      varchar(15) null comment '联系人姓名',
    addressDesc  varchar(50) null comment '收货地址明细',
    postCode     varchar(15) null comment '邮编',
    tel          varchar(20) null comment '联系人电话',
    createdBy    bigint      null comment '创建者',
    creationDate datetime    null comment '创建时间',
    modifyBy     bigint      null comment '修改者',
    modifyDate   datetime    null comment '修改时间',
    userId       bigint      null comment '用户ID'
)
    collate = utf8mb3_unicode_ci;

INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (1, '王丽', '北京市东城区东交民巷44号', '100010', '13678789999', 1, '2016-04-13 00:00:00', null, null, 1);
INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (2, '张红丽', '北京市海淀区丹棱街3号', '100000', '18567672312', 1, '2016-04-13 00:00:00', null, null, 1);
INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (3, '任志强', '北京市东城区美术馆后街23号', '100021', '13387906742', 1, '2016-04-13 00:00:00', null, null, 1);
INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (4, '曹颖', '北京市朝阳区朝阳门南大街14号', '100053', '13568902323', 1, '2016-04-13 00:00:00', null, null, 2);
INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (5, '李慧', '北京市西城区三里河路南三巷3号', '100032', '18032356666', 1, '2016-04-13 00:00:00', null, null, 3);
INSERT INTO smbms.smbms_address (id, contact, addressDesc, postCode, tel, createdBy, creationDate, modifyBy, modifyDate, userId) VALUES (6, '王国强', '北京市顺义区高丽营镇金马工业区18号', '100061', '13787882222', 1, '2016-04-13 00:00:00', null, null, 3);


```



配置环境

```xml web.xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
    http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0"
         metadata-complete="false">
</web-app>
```

导入jar包

```xml pom.xml
<dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.11</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/mysql/mysql-connector-java -->
    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>8.0.28</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet/javax.servlet-api -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>4.0.1</version>
      <scope>provided</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet.jsp/jsp-api -->
    <dependency>
      <groupId>javax.servlet.jsp</groupId>
      <artifactId>jsp-api</artifactId>
      <version>2.2</version>
      <scope>provided</scope>
    </dependency>
    <!-- https://mvnrepository.com/artifact/taglibs/standard -->
    <dependency>
      <groupId>taglibs</groupId>
      <artifactId>standard</artifactId>
      <version>1.1.2</version>
    </dependency>
    <!-- https://mvnrepository.com/artifact/javax.servlet/jstl -->
    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>jstl</artifactId>
      <version>1.2</version>
    </dependency>
```

根据数据库编写实体类 （entity）ORM映射  持久化避免每次查询去访问数据库例：

```java Role.java
    private Integer id;
    private String roleCode;
    private String roleName;
    private Integer createdBy;
    private Date creationDate;
    private Integer modifyBy;
    private Date modifyDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Integer getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

```

编写公共类

- 数据库配置文件 db.properties

  - ```properties
    drive=com.mysql.cj.jdbc.Driver
    url=jdbc:mysql://localhost:3306/smbms?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
    dbuser=root
    password=123456
    ```

- [JAVA MySQL连接池_加盐盐盐的博客-CSDN博客_java连接池连接mysql](https://blog.csdn.net/weixin_43929113/article/details/90728413?spm=1001.2101.3001.6650.10&utm_medium=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-10-90728413-blog-113337898.pc_relevant_multi_platform_whitelistv3&depth_1-utm_source=distribute.pc_relevant.none-task-blog-2~default~CTRLIST~Rate-10-90728413-blog-113337898.pc_relevant_multi_platform_whitelistv3&utm_relevant_index=12)

  - 设置公共数据库连接方法

  - ```java
    public class DbPool {
    //连接池
        private List<Connection> cs=new ArrayList<Connection>();
        int size=5;
        private   String drive=null;
        private  String url=null;
        private  String dbuser=null;
        private  String password=null;
        private static volatile DbPool dbpool;
         private  DbPool(){}
        
       public static DbPool getDbPool() throws SQLException, IOException, ClassNotFoundException {
        if(dbpool==null){//单例模式只能获取一
            个对象
            dbpool=new DbPool();
            dbpool.init();//初始化
        }
        return dbpool;
        }
        private   void init() throws IOException, ClassNotFoundException, SQLException {
            //获取properties文件数据
        InputStream resourceAsStream = DbPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        drive= properties.getProperty("drive");
        url=properties.getProperty("url");
        dbuser= properties.getProperty("dbuser");
        password=properties.getProperty("password");
    
       String value=null;
       value=(String) properties.get("size");//判断properties文件有没有设置连接数
        if(value!=null) this.size=Integer.parseInt(value);
    
        //加载sql驱动
        Class.forName(drive);
        //创建连接池
        for (int i = 0; i < size; i++) {
            Connection c=DriverManager.getConnection(url,dbuser,password);
            System.out.println("创建第"+(i+1)+"个连接");
            cs.add(c);
            }
    
        }
        //synchronized 线程安全性
        public synchronized Connection getConnect(){
            try {
            while(cs.isEmpty()){//判断连接池是否为空如果为空则等待
                    this.wait();
            }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //移除第一个连接池
            Connection c=cs.remove(0);
            return c;
        }
        public synchronized void returnConnect(Connection c){
           // 使用完给回连接池中唤醒wait告诉它有新的连接池可用
            cs.add(c);
            this.notifyAll();
        }
    
    }
    ```

    编写dao层接口

 ```java
    public interface UserDao {
        public User getUserCodeEnt(Connection c, String Usercode);
    }
 ```

获取登录用户的信息赋值给实体类

 ```java
    public class UserDaoImpl implements UserDao {
        public User getUserCodeEnt(Connection c, String Usercode) {
            ResultSet rs = null;
            PreparedStatement ps = null;
            User user = null;
    
            if (c != null) {
                String sql = "select * from smbms_user where userCode=?";
                Object[] o = {Usercode};
                try {
                    rs = BaseDao.excute(sql, o, c, ps, rs);
                    user = new User();
                    GetResultSetEntity gsu = new GetResultSetEntity();
                    user = gsu.SetUser(user, rs);//利用反射获取方法判断字段属性给user类赋值
    
    
    //            if(rs.next()) {
    //                //user.setId( rs.getInt("id"));//传统方法获取
    //            }
    
                } catch (Exception e) {
                    //BaseDao.closeResource(null,ps,rs);
                    e.printStackTrace();
                }
            }
            BaseDao.closeResource(null,ps,rs);
    
            return user;
        }
 ```

[如何用反射给实体类赋值_锦鲤(⑉°з°)--♡的博客-CSDN博客_反射给实体类赋值](https://blog.csdn.net/qq_40036240/article/details/90900210)

```java
public class GetResultSetEntity {
    public User SetUser(User s,ResultSet rs) throws ClassNotFoundException, SQLException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class userclass=Class.forName("com.Slzr.entity.User");//使用反射获取class内容
        Field [] fields=userclass.getDeclaredFields();//获取class的字段属性
        ResultSetMetaData rsdata=rs.getMetaData();//获取resultset的列名称和类型信息
        int count=rsdata.getColumnCount();//获取resultset的列表列数

        if(rs.next()) {
            for (int i = 1; i <= count; i++) {
                String name = rsdata.getColumnName(i);//获取列名
                for (Field f : fields) {
                    if (name.equals(f.getName())) {//判断属性名称和数据库字段名称是否相同
                        Method method = null;//提取方法
                        String type=f.getGenericType().toString();//获取属性类型

                        //判断User类属性 并进行赋值
                        if ("class java.lang.Integer".equals(type)) {

                            method = userclass.getMethod("set"+f.getName().substring(0, 1).toUpperCase()+ name.substring(1) , Integer.class);
                            method.invoke(s, rs.getInt(name));//set首字母大写
                        }

                        if (type.equals("class java.lang.String")) {

                            method = userclass.getMethod("set"+f.getName().substring(0, 1).toUpperCase()+ name.substring(1) , String.class);
                            method.invoke(s, rs.getString(i));
                        }
                        if (type.equals("class java.util.Date")) {

                            method = userclass.getMethod("set"+f.getName().substring(0, 1).toUpperCase()+name.substring(1), Date.class);
                            method.invoke(s, rs.getDate(i));
                        }
                    }
                }
            }
        }
        return s;
    }
}
```


编写业务层接口

```java
	   public interface  Userservices {
        public User LoginUser(String username,String pwd);
    }
```


 编写业务层实现类

```java
    public class UserservicesImpL implements Userservices{
        //引用Dao层
        private UserDao userdao;
        public UserservicesImpL(){
            userdao=new UserDaoImpl();//构造方法创建userdao对象
        }
        @Override
        public User LoginUser(String usercode, String pwd) {
            Connection c=null;
            User user=null;
            c= BaseDao.getconnect();
           user= userdao.getUserCodeEnt(c,usercode);
            System.out.println(user.toString());
            BaseDao.closeResource(c,null,null);
            if(null != user.getId()){
                if(!user.getUserPassword().equals(pwd))
                    user = null;
            }
    
            return user;
    
        }
    }
```


编写Servlet

 ```java
    public class Constants {
        public final static String User_Session="userSession";//设置用户session静态常量
    }
 ```

 ```java
    
    @WebServlet(name = "login",value = "/login.do")
    public class UserServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doPost(req,resp);
    
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //控制层
            Userservices loginuser=new UserservicesImpL();
            HttpSession session1=null;
            User user=null;
           String usercode=req.getParameter("userCode");
           String pwd= req.getParameter("userPassword");
            user= loginuser.LoginUser(usercode,pwd);
            if(user!=null){
               session1= req.getSession();
               session1.setAttribute(Constants.User_Session,user);
               //session1.setAttribute("userSession","user.getUserName().toString()");
                resp.sendRedirect(req.getContextPath()+"/jsp/frame.jsp");
            }else{
                req.setAttribute("error","用户名或密码错误");
                req.getRequestDispatcher("login.jsp").forward(req,resp);
            }
    
        }
    }
 ```



用户退出控制servlet

```java
    @WebServlet(name = "loginout",value = "/jsp/logout.do")
    public class LoginoutServlet extends HttpServlet {
    
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                req.getSession().removeAttribute(Constants.User_Session);
                resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
    
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            doGet(req, resp);
        }
    }
```



过滤用户拦截

```java
    public class Loginaccess implements Filter {
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {


    
            HttpServletResponse hresp=(HttpServletResponse)servletResponse;
            HttpServletRequest hreq=(HttpServletRequest)servletRequest;
            User user=(User)hreq.getSession().getAttribute(Constants.User_Session);


    
            if(user==null) {
                hresp.sendRedirect(hreq.getContextPath() + "/error.jsp");
            }
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }
```


设置web.xml


 ```xml
<welcome-file-list>
    <welcome-file>/login.jsp</welcome-file>
</welcome-file-list>
<filter>
    <filter-name>setencoding</filter-name>
    <filter-class>com.Slzr.filter.SetEncoding</filter-class>
</filter>
<filter-mapping>
    <filter-name>setencoding</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
<filter>
    <filter-name>loginaccess</filter-name>
    <filter-class>com.Slzr.filter.Loginaccess</filter-class>
</filter>
<filter-mapping>
    <filter-name>loginaccess</filter-name>
    <url-pattern>/jsp/*</url-pattern>
</filter-mapping>
 ```











# idea使用git上传到github

idea版本2022.1.3  git版本2.37.2

使用https url链接和ssh密钥链接提示

```
Enumerating objects: 61, done.
......
Writing objects:  96% (59/61), 2.49 MiB | 10.00 KiB/s
client_loop: send disconnect: Broken pipe
send-pack: unexpected disconnect while reading sideband packet
fatal: sha1 file '<stdout>' write error: Broken pipe
fatal: the remote end hung up unexpectedly
```

idea上传github失败问题 在github上创建了仓库但上传代码失败

期间idea删除了github账号使用token添加

删除了之前SSH keys 使用web https url进行上传提示失败

```
Total 89 (delta 23), reused 0 (delta 0), pack-reused 0
error: RPC failed; curl 92 HTTP/2 stream 0 was not closed cleanly: CANCEL (err 8)
send-pack: unexpected disconnect while reading sideband packet
fatal: the remote end hung up unexpectedly
```

网上方法 修改配置

```
git config --global http.version HTTP/1.1
git config --global http.postBuffer 524288000
```

依旧提示错误

```
Total 89 (delta 23), reused 0 (delta 0), pack-reused 0
error: RPC failed; curl 18 transfer closed with outstanding read data remaining
send-pack: unexpected disconnect while reading sideband packet
fatal: the remote end hung up unexpectedly
```

网上方法修改配置

```
git config --global http.postBuffer 2024288000
```

提示错误

```
fatal: unable to access 'https://github.com/1303144162/SMBMSpro.git/': Empty reply from server
```

重新创建ssh密钥

```
ssh -keygen -t rsa -C "email@qq.com"
```

修改上传仓库地址为git@github.com:.....

上传成功

```
To github.com:email/project.git
*	refs/heads/test2:refs/heads/test2	[new branch]
*	refs/tags/master:refs/tags/master	[new tag]
branch 'test2' set up to track 'origin/test2'.
Done
```

之后在仓库发现有其他的镜像链接仓库地址没有尝试

[IDEA中对Git的常规操作(合并,提交,新建分支,更新)_Loveme_CN的博客-CSDN博客_idea中git更新分支](https://blog.csdn.net/Loveme_CN/article/details/123783559)
