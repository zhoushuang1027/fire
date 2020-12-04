package es.gob.fire.persistence.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;

import es.gob.fire.persistence.dto.ApplicationDTO;
import es.gob.fire.persistence.dto.ApplicationEditDTO;
import es.gob.fire.persistence.entity.Application;
import es.gob.fire.persistence.entity.Certificate;

/** 
 * <p>Interface that provides communication with the operations of the persistence layer.</p>
 * <b>Project:</b><p>Platform for detection and validation of certificates recognized in European TSL.</p>
 * @version 1.0, 15/10/2020.
 */


public interface IApplicationService {
	
	/**
	 * Method that obtains an application by its identifier.
	 * @param appId The user identifier.
	 * @return {@link Application}
	 */
	Application getAppByAppId(String appId);
	
	/**
	 * Method that obtains an user by its app name.
	 * @param appName The app name.
	 * @return {@link app}
	 */
	Application getAppByAppName(String appName);
	
	
	
	/**
	 * Method that stores a user in the persistence.
	 * @param user a {@link User} with the information of the user.
	 * @return {@link User} The user.
	 */
	Application saveApplication(Application app);
	
//	/** Method that stores a user in the persistence from User DTO object.
//	 * @param userDto a {@link UserDTO} with the information of the user.
//	 * @return {@link User} The user.
//	 */
//	Application saveApplication(ApplicationDTO appDto);
//	
//	/**
//	 * Method that updates a user in the persistence.
//	 * @param userEditDto a {@link UserEditDTO} with the information of the user.
//	 * @return {@link User} The user.
//	 */
//	Application updateApplication(ApplicationEditDTO appEditDto);
//			
	/**
	 * Method that deletes a application in the persistence.
	 * @param appId {@link Integer} that represents the application identifier to delete.
	 */
	void deleteApplication(String appId);
	
	/**
	 * Method that gets all the app from the persistence.
     * @return a {@link Iterable<Application>} with the information of all application.
	 */
	Iterable<Application> getAllApplication();
	
	
//	
//	/**
//	 * Method that gets all the app certificates from the persistence.
//	 * @return a {@link Iterable<Certificate>} with the information of all certificate.
//	 */
//	List<Certificate> getAllCertificate();
//		
	/**
	 * Method that gets the list for the given {@link DataTablesInput}.
	 * @param input the {@link DataTablesInput} mapped from the Ajax request.
	 * @return {@link DataTablesOutput}
	 */
	DataTablesOutput<Application> getAllApplication(DataTablesInput input);
	

}