var express = require("express");
var app = express();
var bodyParser = require("body-parser");

app.use(express.static("static"));
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());

app.get("/index.html", function(req, res) 
{	res.sendFile( __dirname + "/static/" + "geradorDeReferencias.html" );
});

app.post("/gerarReferencia", function(req, res) 
{	// Envia resposta em formato JSON
	response = 
    {	
        "ultimo_nome": req.body.ultimo_nome,
        "iniciais": req.body.iniciais,
        "titulo": req.body.titulo,
        "edicao": req.body.edicao,
        "local": req.body.local,
        "editora": req.body.editora,
        "ano": req.body.ano
	};
	
	console.log(response);
	res.end(JSON.stringify(response));
});

var server = app.listen(8081, function () 
{	console.log("Server running at http://127.0.0.1:8081/");
});