(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-b242aa48"],{b0c0:function(e,t,a){var s=a("83ab"),r=a("9bf2").f,n=Function.prototype,l=n.toString,i=/^\s*function ([^ (]*)/,o="name";s&&!(o in n)&&r(n,o,{configurable:!0,get:function(){try{return l.call(this).match(i)[1]}catch(e){return""}}})},ddf4:function(e,t,a){"use strict";a.r(t);var s=function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-dialog",{attrs:{title:"Modify User",visible:e.dialogFormVisible},on:{"update:visible":function(t){e.dialogFormVisible=t}}},[a("el-form",{ref:"dataForm",attrs:{model:e.selectedUser,"label-suffix":":"}},[a("el-form-item",{attrs:{label:"Id","label-width":"120px",prop:"username"}},[a("label",[e._v(e._s(e.selectedUser.id))])]),a("el-form-item",{attrs:{label:"Name","label-width":"120px",prop:"name"}},[a("el-input",{attrs:{placeholder:"User Name",clearable:""},model:{value:e.selectedUser.name,callback:function(t){e.$set(e.selectedUser,"name",t)},expression:"selectedUser.name"}})],1),a("el-form-item",{attrs:{label:"Password","label-width":"120px",prop:"password"}},[a("el-input",{attrs:{placeholder:"User Password",clearable:""},model:{value:e.selectedUser.password,callback:function(t){e.$set(e.selectedUser,"password",t)},expression:"selectedUser.password"}})],1)],1),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"info"},on:{click:function(t){e.dialogFormVisible=!1}}},[e._v("Cancel")]),a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.onSubmit(e.selectedUser)}}},[e._v("Submit")])],1)],1),a("el-row",{staticStyle:{margin:"58px 0px 0px 76px"}},[a("el-breadcrumb",{attrs:{"separator-class":"el-icon-arrow-right"}},[a("el-breadcrumb-item",{attrs:{to:"/admin/dashboard"}},[e._v("Admin Management")]),a("el-breadcrumb-item",[e._v("User Management")])],1)],1),a("el-card",{staticStyle:{margin:"38px 5%",width:"90%"}},[a("el-table",{ref:"multipleTable",staticStyle:{width:"100%"},attrs:{data:e.users,stripe:"","max-height":e.tableHeight}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),a("el-table-column",{attrs:{prop:"id",label:"Id",sortable:""}}),a("el-table-column",{attrs:{prop:"name",label:"Name"}}),a("el-table-column",{attrs:{prop:"password",label:"Password"}}),a("el-table-column",{attrs:{label:"Operation",width:"120"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{type:"primary",icon:"el-icon-edit",circle:"",size:"small"},on:{click:function(a){return e.editUser(t.row)}}}),a("el-button",{attrs:{type:"danger",icon:"el-icon-delete",circle:"",size:"small"},on:{click:function(a){return e.deleteUser(t.row.id)}}})]}}])})],1),a("div",{staticStyle:{margin:"20px 0",float:"right"}},[a("el-pagination",{attrs:{background:"",layout:"prev, pager, next,->,total","current-page":e.currentPage,"page-size":e.pageSize,total:e.total,"page-count":e.pageCount},on:{"current-change":e.handleCurrentChange}})],1)],1)],1)},r=[],n=(a("b0c0"),{name:"UserProfile",data:function(){return{users:[],dialogFormVisible:!1,selectedUser:{},currentPage:1,pageSize:5,total:0,pageCount:0}},methods:{listUsers:function(){var e=this;this.$axios.get("/admin/users",{params:{page:this.currentPage-1}}).then((function(t){t&&200===t.status&&(e.users=t.data.content,e.currentPage=t.data.number+1,e.pageSize=t.data.size,e.total=t.data.totalElements,e.pageCount=t.data.totalPages)}))},handleCurrentChange:function(e){this.currentPage=e,this.listUsers()},editUser:function(e){this.dialogFormVisible=!0,this.selectedUser=e},deleteUser:function(e){var t=this;this.$confirm("This operation will permanently delete the user. Do you want to continue?","del_tip",{confirmButtonText:"Yes",cancelButtonText:"No",type:"warning"}).then((function(){t.$axios.delete("/admin/user/delete/".concat(t.$store.getters.getUser),{data:{id:e}}).then((function(e){e&&200===e.status&&(t.$message.success("Deleted Successfully"),t.listUsers())})).catch((function(e){t.$message.warning("you can't delete yourself")}))}))},onSubmit:function(e){var t=this;this.$axios.put("/admin/user",{id:e.id,name:e.name,password:e.password}).then((function(e){e&&200===e.status&&(t.$message.success(e.data),t.dialogFormVisible=!1,t.listUsers())}))}},computed:{tableHeight:function(){return window.innerHeight-320}},mounted:function(){this.listUsers()}}),l=n,i=a("2877"),o=Object(i["a"])(l,s,r,!1,null,"37658eae",null);t["default"]=o.exports}}]);