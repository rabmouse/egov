//这是封装表单验证的方法

//创建一个表单类，表单类里面有表单项：文本框、密码框、下拉列表框等等
//textContext：是表单项的文本内容
//elementId：是表单项的唯一id
FormElement = function (textContext,elementId) {
    //给表单项的对象属性textContext赋值
    this.textContext = textContext;
    //给表单项的对象属性elementId赋值
    this.elementId = elementId;
}

//创建一个表单验证的工具类，里面提供了表单验证的各种方法
FormCheckUtils = function () {

    //非空判断,参数是一个表单项的数组
    this.isNull = function (formElementArr) {
        for (var i=0;i<formElementArr.length;i++){
            //这是表单数组里面的具体表单项
            var formElement = formElementArr[i];
            //获取表单项的id
            var eleId = formElement.elementId;
            //表单项的value属性值
            var value = $("#"+eleId).val();

            //进行非空判断
            if(value === ""){
                alert(formElement.textContext+"为空，请重新输入");
                $("#"+eleId).focus();
                return false;
            }
            //进行下拉列表框的选择判断
            if(value == -1){
                alert("请选择您的"+formElement.textContext);
                return false;
            }
        }
        return true;
    }

    //进行用户密码和确认密码是否一致判断
    //formElement1:用户密码文本框对象
    //formElement2：确认密码文本框对象
    this.isSame = function (formElement1,formElement2) {
        //获取用户密码的文本框id
        var pswdId = formElement1.elementId;
        //获取确认密码的文本框id
        var pswdCheck = formElement2.elementId;
        //获取用户密码的文本框jq对象
        var pswdJq = $("#"+pswdId)
        //获取确认密码的文本框jq对象
        var pswdCheckJq = $("#"+pswdCheck)
        //进行密码是否一致判断
        if(pswdJq.val() != pswdCheckJq.val()){
            alert(formElement1.textContext +"与"+formElement2.textContext+"不一致，请重新输入");
            pswdJq.val("");
            pswdCheckJq. val("");
            pswdJq.focus();
            return false;
        }
        return true;
    }


}

//html加载的时候就创建FormCheckUtils对象
var $$ = new FormCheckUtils();