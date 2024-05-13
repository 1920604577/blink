import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);

const routes = [
  {
    path: "/", // 将路径改为小写
    meta: { name: "登录界面" },
    component: (resolve) => require(["../pages/Login.vue"], resolve),
  },
  //我的列表内容
  {
    path: "*",
    name: "404",
    component: (resolve) => require(["../components/Error.vue"], resolve),
  },
  {
    path: "/home",
    name: "Home",
    component: (resolve) => require(["../components/Home.vue"], resolve),
    children: [
      {
        path: "/index",
        name: "Index",
        meta: { name: "系统首页" },
        component: (resolve) => require(["../components/Index.vue"], resolve),
      },
      {
        path: "/user",
        name: "User",
        meta: { name: "用户信息" },
        component: (resolve) => require(["../components/User.vue"], resolve),
      },
      {
        path: "/admin",
        name: "Admin",
        meta: { name: "管理员信息" },
        component: (resolve) => require(["../components/Admin.vue"], resolve),
      },
      {
        path: "/queryProfiles",
        name: "QueryProfiles",
        meta: { name: "查看嘉宾" },
        component: (resolve) =>
          require(["../pages/QueryProfiles.vue"], resolve),
      },
      {
        path: "/info",
        name: "Info",
        meta: { name: "关于我们" },
        component: (resolve) => require(["../pages/InfoPage.vue"], resolve),
      },
    ],
  },
  {
    path: "/userReg",
    name: "UserReg",
    meta: { name: "用户注册" },
    component: (resolve) => require(["../pages/UserRegPage.vue"], resolve),
  },
  {
    path: "/profiles",
    name: "Profiles",
    meta: { name: "个人信息" },
    component: (resolve) => require(["../pages/Profiles.vue"], resolve),
  },
  {
    path: "/notice",
    name: "Notice",
    meta: { name: "消息" },
    component: (resolve) => require(["../pages/Notice.vue"], resolve),
  },
  {
    path: "/myBlink",
    name: "MyBlink",
    meta: { name: "消息" },
    component: (resolve) => require(["../pages/MyBlink.vue"], resolve),
  },
  {
    path: "/replace",
    name: "Replace",
    meta: { name: "回复" },
    component: (resolve) => require(["../pages/Replace.vue"], resolve),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
