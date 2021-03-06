# JavaEE综合实验

Editor: Caiman Wu

简单的购物网站（包括购物车功能）

---

使用技术：MongoDB和JSP

---

## 实现功能：
（1）用户登录。（通过查询MongoDB数据库，完成登录认证）<br>
（2）用户注册。（通过写入MongoDB数据库，完成用户注册）<br>
（3）记住密码。（通过使用Cookie，实现记住首页用户名和密码功能）<br>
（4）查看商品。（通过查询MongoDB数据库，返回商品具体信息，并显示在客户端界面）<br>
（5）购买商品。<br>
（6）购物车。（显示用户购买商品具体信息，删除已购买商品或添加已购买商品数量，计算用户当前购买商品总价格）<br>
（7）管理员登录 （通过查询MongoDB数据库，完成登录认证）<br>
（8）后台商品的增删查改。（通过查询MongoDB数据库，进行增加删除商品操作，并显示在客户端界面）<br>
<br>
## 文件结构：<br>
jsp结构，javaBean结构，数据库结构<br>
<br>
**登录界面（login.jsp)**<br>
 ![login](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片1.png)<br>
 * 输入账号密码，传值到login_action.jsp处理后不匹配，跳转到login_Fail.jsp（登录失败页面）：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片2.png)<br>
 * 登录页面中注册新账号register.jsp(注册页面)：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片3.png)<br>
 * 如果传值到login_action.jsp处理匹配，跳转到welcome.jsp（商品主页面）：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片4.png)<br>
 * 点击购买，传值到Buy.jsp，调用MongoDBBean的Java类进行处理。点击查看购物车，跳转到购物车界面（Cart.jsp）：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片5.png)<br>
 * 登录页面中选择管理员登录adnim.jsp(登录页面)：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片6.png)<br>
 * 选择增加商品，跳转到good_add.jsp页面，输入商品的信息：<br>
 ![](https://github.com/Greedddd/shopping-Web/raw/master/introduction/图片7.png)<br>
