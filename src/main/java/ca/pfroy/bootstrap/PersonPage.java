package ca.pfroy.bootstrap;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class PersonPage implements Serializable {

    private static final Logger logger = Logger.getLogger(PersonPage.class.getName());

    @Inject
    private PersonRepository personRepository;

    private int selectedId;

    private Person selectedPerson;

    public void loadPerson() {
        logger.log(Level.INFO, "load person => {0}", selectedId);
        selectedPerson = personRepository.getPerson(selectedId);
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }

    public int getSelectedId() {
        return selectedId;
    }

    public Person getSelectedPerson() {
        return selectedPerson;
    }

    public List<Person> getPersons() {
        return personRepository.getPersons();
    }

    public void addInfoMessage() {
        FacesContext ctx = FacesContext.getCurrentInstance();
        String msg = "View action " + (ctx.isPostback() ? "on postback" : "on initial request");
        ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, null));
        ctx.getExternalContext().getFlash().setKeepMessages(true);
    }
}
