package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovy.json.internal.LazyMap;
import org.junit.Assert;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.E;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import definition.CrudProcessos;
import support.RESTSupport;

public class CrudProcessosSteps {
    @Dado("^que o usuário está na página de processos$")
    @Given("^that the user is in the processos page$")
    public void queOUsuarioEstaNaPaginaDeProcessos() {
        CrudProcessos.clearFields();
    }

    @E("^o usuário informa no campo \"([^\"]*)\" o valor \"([^\"]*)\"$")
    public void oUsuarioInformaNoCampoOValor(String campo, String valor) throws Throwable {
        CrudProcessos.addFields(campo, valor);
    }

    @When("^the user clicks in the add button$")
    @Quando("^o usuário clicar em salvar$")
    public void oUsuarioClicarEmSalvar() {
        RESTSupport.executePost(CrudProcessos.getEndPoint(),CrudProcessos.getFields());
        CrudProcessos.setLastID(RESTSupport.key("id").toString());
    }

    @Then("^the user should see the message \"([^\"]*)\"$")
    @Então("^o usuário deveria receber uma mensagem de \"([^\"]*)\"$")
    public void oUsuarioDeveriaReceberUmaMensagemDe(String message) throws Throwable {
        LazyMap messageJson = new LazyMap();
        messageJson.put("salvo com sucesso", 201);
        messageJson.put("sucesso", 200);
        messageJson.put("sem conteudo", 204);
        messageJson.put("nao encontrado", 404);
        messageJson.put("nao autorizado", 401);
        messageJson.put("Created", 201);
        messageJson.put("OK", 200);
        messageJson.put("No Content", 204);
        messageJson.put("Not Found", 404);
        messageJson.put("Unauthorized", 401);

        Assert.assertEquals(messageJson.get(message),RESTSupport.getResponseCode());
    }

    @And("^the user would like to see the processo with the id (\\d+)$")
    @E("^o usuário gostaria de visualizar o processo com o id (\\d+)$")
    public void oUsuárioGostariaDeVisualizarOProcessoComOId(int id) {
        CrudProcessos.setLastID(String.valueOf(id));
    }

    @When("^the user clicks in the load button$")
    @Quando("^o usuário clicar em visualizar$")
    public void oUsuárioClicarEmVisualizar() {
        RESTSupport.executeGet(CrudProcessos.getEndPoint() + "/" + CrudProcessos.getLastID() + ".json");
    }

    @And("^the user should see the field \"([^\"]*)\" with the value \"([^\"]*)\"$")
    @E("^o usuário deve ver o campo \"([^\"]*)\"com o valor \"([^\"]*)\"$")
    public void oUsuárioDeveVerOCampoComOValor(String campo, String valor) throws Throwable {
        Assert.assertEquals(valor, RESTSupport.key(campo));
    }

    @When("^the user clicks in the save button$")
    @Quando("^o usuário clicar em atualizar$")
    public void oUsuárioClicarEmAtualizar() {
        RESTSupport.executePut(CrudProcessos.getEndPoint() + "/" + CrudProcessos.getLastID() + ".json",CrudProcessos.getFields());
    }

    @When("^the user clicks in the delete button$")
    @Quando("^o usuário clicar em apagar$")
    public void oUsuárioClicarEmApagar() {
        RESTSupport.executeDelete(CrudProcessos.getEndPoint() + "/" + CrudProcessos.getLastID() + ".json");
    }

    @And("^user informs value \"([^\"]*)\" in the field \"([^\"]*)\"$")
    public void userInformsValueInTheField(String value, String field) throws Throwable {
        CrudProcessos.addFields(field, value);
    }

}
