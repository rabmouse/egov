//���Ƿ�װ����֤�ķ���

//����һ�����࣬���������б���ı�������������б��ȵ�
//textContext���Ǳ�����ı�����
//elementId���Ǳ����Ψһid
FormElement = function (textContext,elementId) {
    //������Ķ�������textContext��ֵ
    this.textContext = textContext;
    //������Ķ�������elementId��ֵ
    this.elementId = elementId;
}

//����һ������֤�Ĺ����࣬�����ṩ�˱���֤�ĸ��ַ���
FormCheckUtils = function () {

    //�ǿ��ж�,������һ�����������
    this.isNull = function (formElementArr) {
        for (var i=0;i<formElementArr.length;i++){
            //���Ǳ���������ľ������
            var formElement = formElementArr[i];
            //��ȡ�����id
            var eleId = formElement.elementId;
            //�����value����ֵ
            var value = $("#"+eleId).val();

            //���зǿ��ж�
            if(value === ""){
                alert(formElement.textContext+"Ϊ�գ�����������");
                $("#"+eleId).focus();
                return false;
            }
            //���������б���ѡ���ж�
            if(value == -1){
                alert("��ѡ������"+formElement.textContext);
                return false;
            }
        }
        return true;
    }

    //�����û������ȷ�������Ƿ�һ���ж�
    //formElement1:�û������ı������
    //formElement2��ȷ�������ı������
    this.isSame = function (formElement1,formElement2) {
        //��ȡ�û�������ı���id
        var pswdId = formElement1.elementId;
        //��ȡȷ��������ı���id
        var pswdCheck = formElement2.elementId;
        //��ȡ�û�������ı���jq����
        var pswdJq = $("#"+pswdId)
        //��ȡȷ��������ı���jq����
        var pswdCheckJq = $("#"+pswdCheck)
        //���������Ƿ�һ���ж�
        if(pswdJq.val() != pswdCheckJq.val()){
            alert(formElement1.textContext +"��"+formElement2.textContext+"��һ�£�����������");
            pswdJq.val("");
            pswdCheckJq. val("");
            pswdJq.focus();
            return false;
        }
        return true;
    }


}

//html���ص�ʱ��ʹ���FormCheckUtils����
var $$ = new FormCheckUtils();