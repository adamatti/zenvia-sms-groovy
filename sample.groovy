@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.7.1')
import groovyx.net.http.RESTClient

RESTClient restClient = new RESTClient("https://api-rest.zenvia360.com.br", "application/json")

def body = ["sendSmsRequest": ["from": "Groovy","to": "REMOVIDO","msg":"minha msg"]]

def user = "REMOVIDO"
def pass = "REMOVIDO"
def authorizarion = "${user}:${pass}".bytes.encodeBase64().toString()

def res = restClient.post(
    path   : "/services/send-sms",
    body   : body,
    headers: ["Authorization": "Basic ${authorizarion}"]
)

println res.data