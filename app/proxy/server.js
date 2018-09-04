var express = require('express');
var path = require('path');
var fs = require('fs');
var app = express();
var http = require('http');
var proxy = require('express-http-proxy');

app.engine('html', require('ejs').renderFile);
app.set('views', path.join(__dirname, '../public'));

app.use('/env', function(req, res, next) {
	var envJsonEndpoints = process.env.jsonEndpoints;
	var defaultEnvJsonpoints = {
		'apiGatewayUrl' : './sdafdsfdflogin/0'
	};

	res.setHeader('X-Endpoints', envJsonEndpoints || JSON.stringify(defaultEnvJsonpoints));
	return res.end('');
});

app.use('/', express.static(path.join(__dirname, '../public')));

app.all('/*', function(req, res) {
	res.sendFile('index.html', {root: path.join(__dirname, '../public/')});
});

app.listen(5000, function(){
	console.log('Server is listening at 5000');
})