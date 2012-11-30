/*
Copyright (c) 2003-2012, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
 */

CKEDITOR.editorConfig = function(config) {
	// Define changes to default configuration here. For example:
	// config.language = 'fr';
	// config.uiColor = '#AADC6E';
	config.width = 940;
	config.height = 300;
	
	config.filebrowserBrowseUrl = 'fileManager.do';
	config.filebrowserUploadUrl = 'fileUpload.do';
	config.filebrowserImageUploadUrl = 'fileUpload.do';
	
	config.filebrowserWindowWidth = '800';  //“浏览服务器”弹出框的size设置
	config.filebrowserWindowHeight = '500';
};
