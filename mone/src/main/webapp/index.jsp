<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- release v4.3.2, copyright 2014 - 2015 Kartik Visweswaran -->
<html lang="en">
    <head>
        <meta charset="UTF-8"/>
        <title>fileinput样例</title>
        <link href="<%=request.getContextPath()%>/resources/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link href="<%=request.getContextPath()%>/resources/js/bootstrap-fileinput/css/fileinput.css" media="all" rel="stylesheet" type="text/css" />
        <script src="<%=request.getContextPath()%>/resources/js/jquery-2.2.0.min.js"></script>
        <script src="<%=request.getContextPath()%>/resources/js/bootstrap-fileinput/js/fileinput.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/resources/js/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="<%=request.getContextPath()%>/resources/js/bootstrap-fileinput/js/locales/zh.js" type="text/javascript"></script>
    </head>
    <body>
    	<a href="<%=request.getContextPath()%>/getL.do">重定向</a>
        <div class="container kv-main">
            <div class="page-header">
            <h1>Bootstrap File Input Example <small><a href="https://github.com/kartik-v/bootstrap-fileinput-samples"><i class="glyphicon glyphicon-download"></i> Download Sample Files</a></small></h1>
            </div>
            <form enctype="multipart/form-data">
                <input id="file-0a" class="file" type="file" multiple data-min-file-count="1">
                <br>
                <button type="submit" class="btn btn-primary">Submit</button>
                <button type="reset" class="btn btn-default">Reset</button>
            </form>
            <hr>
            <form enctype="multipart/form-data">
                <label>Test invalid input type</label>
                <input id="file-0b" class="file" type="text" multiple data-min-file-count="1">
                <script>
                $(document).on('ready', function(){$("#file-0b").fileinput();});
                </script>
            </form>
            <hr>
            <form enctype="multipart/form-data">
                <input id="file-0a" class="file" type="file" multiple data-min-file-count="3">
                <hr>
                 <div class="form-group">
                    <input id="file-0b" class="file" type="file">
                </div>
                <hr>
                <div class="form-group">
                    <input id="file-1" type="file" multiple class="file" data-overwrite-initial="false" data-min-file-count="2">
                </div>
                <hr>
                <div class="form-group">
                    <input id="file-2" type="file" class="file" readonly data-show-upload="false">
                </div> 
                <hr>
                <div class="form-group">
                    <label>Preview File Icon</label>
                    <input id="file-3" type="file" multiple="true">
                </div>
                <hr>
                <div class="form-group">
                    <input id="file-4" type="file" class="file" data-upload-url="#">
                </div>
                <hr>
                <div class="form-group">
                    <button class="btn btn-warning" type="button">Disable Test</button>
                    <button class="btn btn-info" type="reset">Refresh Test</button>
                    <button class="btn btn-primary">Submit</button>
                    <button class="btn btn-default" type="reset">Reset</button>
                </div>
                <hr>
                <div class="form-group">
                    <input type="file" class="file" id="test-upload" multiple>
                    <div id="errorBlock" class="help-block"></div>
                </div>
                <hr>
                <div class="form-group">
                    <input id="file-5" class="file" type="file" multiple data-preview-file-type="any" data-upload-url="#">
                </div>
            </form>
            
            
            <hr>
            <h4>Multi Language Inputs</h4>
            <form enctype="multipart/form-data">
                <label>French Input</label>
                <input id="file-fr" name="file-fr[]" type="file" multiple>
                <hr style="border: 2px dotted">
                <label>Spanish Input</label>
                <input id="file-es" name="file-es[]" type="file" multiple>
            </form>
            <hr>
            <br>
        </div>
    </body>
	<script>
    $('#file-fr').fileinput({
        language: 'zh',
        uploadUrl: '${pageContext.request.contextPath}/common/imgUpLoad.do',
        allowedFileExtensions : ['jpg', 'png','gif','jpeg','tbi'],
    });
    $('#file-es').fileinput({
        language: 'zh',
        uploadUrl: '${pageContext.request.contextPath}/common/imgUpLoad.do',
        allowedFileExtensions : ['jpg', 'png','gif','jpeg','tbi'],
    });
    $("#file-0").fileinput({
        language: 'zh',
        'allowedFileExtensions' : ['jpg', 'png','gif','jpeg','tbi'],
    });
    $("#file-1").fileinput({
        language: 'zh',
        uploadUrl: '${pageContext.request.contextPath}/common/imgUpLoad.do', // you must set a valid URL here else you will get an error
        allowedFileExtensions : ['jpg', 'png','gif','jpeg','tbi'],
        overwriteInitial: false,
        maxFileSize: 1000,
        maxFilesNum: 10,
        //allowedFileTypes: ['image', 'video', 'flash'],
        slugCallback: function(filename) {
            return filename.replace('(', '_').replace(']', '_');
        }
	});
    /*
    $(".file").on('fileselect', function(event, n, l) {
        alert('File Selected. Name: ' + l + ', Num: ' + n);
    });
    */
	$("#file-3").fileinput({
        language: 'zh',
		showUpload: false,
		showCaption: false,
		browseClass: "btn btn-primary btn-lg",
		fileType: "any",
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>"
	});
	$("#file-4").fileinput({
        language: 'zh',
		uploadExtraData: {kvId: '10'}
	});
    $(".btn-warning").on('click', function() {
        if ($('#file-4').attr('disabled')) {
            $('#file-4').fileinput('enable',{
                language: 'zh',});
        } else {
            $('#file-4').fileinput('disable',{
                language: 'zh',});
        }
    });    
    $(".btn-info").on('click', function() {
        $('#file-4').fileinput('refresh', {previewClass:'bg-info',
            language: 'zh',});
    });
    /*
    $('#file-4').on('fileselectnone', function() {
        alert('Huh! You selected no files.');
    });
    $('#file-4').on('filebrowse', function() {
        alert('File browse clicked for #file-4');
    });
    */
    $(document).ready(function() {
        $("#test-upload").fileinput({
            language: 'zh',
            'showPreview' : false,
            'allowedFileExtensions' : ['jpg', 'png','gif','jpeg','tbi'],
            'elErrorContainer': '#errorBlock'
        });
        /*
        $("#test-upload").on('fileloaded', function(event, file, previewId, index) {
            alert('i = ' + index + ', id = ' + previewId + ', file = ' + file.name);
        });
        */
    });
	</script>
</html>