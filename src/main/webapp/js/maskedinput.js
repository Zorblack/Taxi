function createMask() {
    $(function(){
        $("#creatingOrder").mask("9999-99-99 99:99:99");
        $("#startExecutionOrder").mask("9999-99-99 99:99:99");
        $("#closingOrder").mask("9999-99-99 99:99:99");
    });
}