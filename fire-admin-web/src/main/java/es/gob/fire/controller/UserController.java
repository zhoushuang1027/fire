package es.gob.fire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import es.gob.fire.persistence.configuration.model.entity.User;
//import es.gob.fire.persistence.dto.UserDTO;
//import es.gob.fire.persistence.dto.UserEditDTO;
//import es.gob.fire.persistence.dto.UserPasswordDTO;
import es.gob.fire.persistence.configuration.services.ifaces.IUserService;

/**
 * <p>
 * Class that manages the requests related to the Users administration.
 * </p>
 * <b>Project:</b>
 * <p>
 * Application for monitoring services of @firma suite systems.
 * </p>
 *
 * @version 1.2, 28/10/2018.
 */
@Controller
public class UserController {

	/**
	 * Attribute that represents the service object for accessing the
	 * repository.
	 */
	@Autowired
	private IUserService userService;

	/**
	 * Method that maps the list users web requests to the controller and
	 * forwards the list of users to the view.
	 *
	 * @param model
	 *            Holder object for model attributes.
	 * @return String that represents the name of the view to forward.
	 */
	@RequestMapping(value = "useradmin")
	public String index(final Model model) {
		//model.addAttribute("userFormPassword", new UserPasswordDTO());
		//model.addAttribute("userformEdit", new UserEditDTO());
		return "fragments/useradmin.html";
	}

	/**
	 * Method that maps the add user web request to the controller and sets the
	 * backing form.
	 *
	 * @param model
	 *            Holder object for model attributes.
	 * @return String that represents the name of the view to forward.
	 */
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUser(final Model model) {
		//model.addAttribute("userform", new UserDTO());
		model.addAttribute("accion", "add");
		return "modal/userForm";
	}

	/**
	 * Method that opens the modal form password.
	 * @param username String that represents the user's name
	 * @param model view Model object
	 * @return String that represents the navigation HTML fragment
	 */
	@RequestMapping(value = "menupass")
	public String menuPass(@RequestParam("username") final String username, final Model model) {
		final User user = this.userService.getUserByUsername(username);
		//final UserPasswordDTO userFormPassword = new UserPasswordDTO();

	//	userFormPassword.setIdUserFirePass(user.getIdUser());

		//model.addAttribute("userFormPassword", userFormPassword);
		return "modal/userFormPass.html";
	}

	/**
	 * Method that opens the modal form user edit.
	 * @param username String that represents the user's name
	 * @param model view Model object
	 * @return String that represents the navigation HTML fragment
	 */
	@RequestMapping(value = "menuedit")
	public String menuEdit(@RequestParam("username") final String username, final Model model) {
		final User user = this.userService.getUserByUsername(username);
		//final UserEditDTO userFormEdit = new UserEditDTO();
//
//		userFormEdit.setIdUserFireEdit(user.getIdUser());
//		userFormEdit.setNameEdit(user.getName());
//		userFormEdit.setSurnamesEdit(user.getSurnames());
//		userFormEdit.setEmailEdit(user.getEmail());
//		userFormEdit.setUsernameEdit(user.getUsername());
//
//		model.addAttribute("userformEdit", userFormEdit);
		return "modal/userFormEdit.html";
	}

	/**
	 * Method that maps the add user certificate web requests to the controller and forwards to the form
	 * to the view.
	 * @param model Holder object for model attributes.
	 * @param idUser Identifier for the idUser
	 * @return String that represents the name of the view to forward.
	 */
	@RequestMapping(value = "/managecertuser/{idUser}")
	public String manageCertUser(final Model model, @PathVariable("idUser") final Long idUser) {
		model.addAttribute("idUser", idUser);
		return "modal/certUser.html";
	}

	/**
	 * Method that maps the add user web request to the controller and sets the
	 * backing form.
	 *
	 * @param model
	 *            Holder object for model attributes.
	 * @return String that represents the name of the view to forward.
//	 */
	@RequestMapping(value = "addcertuser", method = RequestMethod.POST)
	public String addcertuserForm(final Model model) {
//		model.addAttribute("certUserForm", new CertificateDTO());
//		model.addAttribute("accion", "add");
		return "modal/certUserForm";
	}

	/**
	 * Get userService.
	 * @return userService
	 */
	public IUserService getUserService() {
		return this.userService;
	}

	/**
	 * SetuserService.
	 * @param userServiceP set userService
	 */
	public void setUserService(final IUserService userServiceP) {
		this.userService = userServiceP;
	}

}