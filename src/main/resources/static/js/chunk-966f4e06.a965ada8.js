(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-966f4e06"],{"511fe":function(e,a,t){"use strict";t.r(a);var l=function(){var e=this,a=e.$createElement,t=e._self._c||a;return t("el-form",{ref:"ruleForm",staticClass:"container-login",attrs:{"label-position":"left","label-width":"0px",rules:e.rules,model:e.emailForm}},[t("h3",{staticClass:"title-login"},[e._v("Email")]),t("el-form-item",{attrs:{prop:"username"}},[t("el-input",{attrs:{placeholder:"name","prefix-icon":"el-icon-user"},model:{value:e.emailForm.username,callback:function(a){e.$set(e.emailForm,"username",a)},expression:"emailForm.username"}})],1),t("el-form-item",{attrs:{prop:"email"}},[t("el-input",{attrs:{placeholder:"email","prefix-icon":"el-icon-s-promotion "},model:{value:e.emailForm.email,callback:function(a){e.$set(e.emailForm,"email",a)},expression:"emailForm.email"}})],1),t("el-form-item",{attrs:{prop:"message"}},[t("el-input",{attrs:{type:"textarea",placeholder:"message",autosize:{minRows:3,maxRows:8},clearable:"",maxlength:"1000","show-word-limit":""},model:{value:e.emailForm.message,callback:function(a){e.$set(e.emailForm,"message",a)},expression:"emailForm.message"}})],1),t("div",{staticClass:"login_remember"}),t("el-form-item",{staticStyle:{width:"100%"}},[t("router-link",{attrs:{to:"/login"}},[t("el-button",{staticClass:"btn-login",staticStyle:{float:"left"},attrs:{type:"info"}},[e._v("Cancel")])],1),t("el-button",{staticClass:"btn-login",staticStyle:{float:"right"},attrs:{type:"primary"},on:{click:e.login}},[e._v("Send")])],1)],1)},s=[],i={name:"Email",data:function(){return{emailForm:{username:"",email:"",message:""},rules:{username:[{required:!0,message:"Name can't be empty",trigger:"blur"}],email:[{required:!0,message:"Email can't be empty",trigger:"blur"},{type:"email",message:"Please input the correct email address",trigger:["blur","change"]}]},loading:!1,checked:!0}},methods:{login:function(){var e=this;this.$refs.ruleForm.validate((function(a){if(!a)return!1;e.$axios.post("/email",{username:e.emailForm.username,email:e.emailForm.email,message:e.emailForm.message}).then((function(a){200===a.status&&(e.$message.success("send email successfully"),e.emailForm={username:"",email:"",message:""})})).catch((function(a){e.$message.error("send email failed")}))}))}}},r=i,m=(t("b99e"),t("2877")),o=Object(m["a"])(r,l,s,!1,null,"762d06c6",null);a["default"]=o.exports},b99e:function(e,a,t){"use strict";var l=t("d0d7"),s=t.n(l);s.a},d0d7:function(e,a,t){}}]);