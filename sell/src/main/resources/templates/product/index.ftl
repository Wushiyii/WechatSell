<html>
<#include "../common/header.ftl">
<body>

<div id="wrapper" class="toggled">
<#--边栏-->
<#include "../common/nav.ftl">
<#--主要内容-->
    <div id="page-content-wrapper">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-4 column">
                    <form role="form">
                        <div class="form-group">
                            <label >名称</label>
                            <input name="productName" type="text" class="form-control"  value="${(productInfo.productName)!""}" />
                        </div>
                        <div class="form-group">
                            <label >价格</label>
                            <input name="productName" type="text" class="form-control"  value="${(productInfo.productPrice)!""}" />
                        </div>

                        <div class="form-group">
                            <label>库存</label>
                            <input name="productStock" type="text" class="form-control" value="${(productInfo.productStock)!''}"/>
                        </div>
                        <div class="form-group">
                            <label>描述</label>
                            <input name="productDescription" type="text" class="form-control" value="${(productInfo.productDescription)!''}"/>
                        </div>

                        <div class="checkbox">
                            <label><input type="checkbox" />Check me out</label>
                        </div> <button type="submit" class="btn btn-info">Submit</button>
                    </form>
                </div>
                <div class="col-md-4 column">
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
<#--<#list orderDTOPage.content as orderDTO>-->
<#--${orderDTO.orderId}<br>-->

<#--</#list>-->