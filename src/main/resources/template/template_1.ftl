<style>.qmbox body {
    font-family: Verdana, sans-serif;
    font-size: 0.8em;
    color:#484848;
}
.qmbox h1,.qmbox h2,.qmbox h3{ font-family: "Trebuchet MS", Verdana, sans-serif; margin: 0px; }
.qmbox h1 { font-size: 1.2em; }
.qmbox h2,.qmbox h3{ font-size: 1.1em; }
.qmbox a,.qmbox a:link,.qmbox a:visited{ color: #2A5685;}
.qmbox a:hover,.qmbox a:active{ color: #c61a1a; }
.qmbox a.wiki-anchor { display: none; }
.qmbox fieldset.attachments {border-width: 1px 0 0 0;}
.qmbox hr {
    width: 100%;
    height: 1px;
    background: #ccc;
    border: 0;
}
.qmbox span.footer {
    font-size: 0.8em;
    font-style: italic;
}
</style>


<strong> ${updater}</strong> ------> <strong>${updateTime}</strong>

<ul>

<#list items as i>
    <li> <a href="http://rap.shzhiduan.com:9090/workspace/myWorkspace.do?projectId=${i.projectID}#${i.itemID}" style="text-decoration: underline; color:#336699; font-size: 14px" target="_blank">${i.itemName}</a> : <i>${i.modifyType}</i></li>
</#list>
</ul>


<#--<hr>-->

<#--<ul>-->
<#--<li>负责人: ${author}</li>-->
<#--<li>状态: ${status}</li>-->
<#--<li>版本:${version}</li>-->
<#--</ul>-->
<hr>
<span class="footer"><p>You have received this notification because you have either subscribed to it, or are involved in it.<br>To change your notification preferences, please click here: <a class="external" href="http://rap.shzhiduan.com:9090/" target="_blank">http://rap.shzhiduan.com:9090/</a></p></span>



<style type="text/css">.qmbox style, .qmbox script, .qmbox head, .qmbox link, .qmbox meta {display: none !important;}</style></div></div><!-- --><style>#mailContentContainer .txt {height:auto;}</style>