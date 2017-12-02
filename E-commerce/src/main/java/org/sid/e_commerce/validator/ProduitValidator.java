package org.sid.e_commerce.validator;

import org.sid.e_commercebackend.beans.Produit;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProduitValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Produit.class.equals("clazz");
	}

	@Override
	public void validate(Object target, Errors errors) {
		Produit produit = (Produit) target;
		if(produit.getFile().getOriginalFilename().equals("")||
				produit.getFile()==null){
			errors.rejectValue("file", null, "please select an image file to upload");
			return;
		}
		if(!(
			produit.getFile().getContentType().equals("image/jpeg")||
			produit.getFile().getContentType().equals("image/png")||
			produit.getFile().getContentType().equals("image/gif")
			    ))
				{
					errors.rejectValue("file", null, "please use only  image file for upload");
					return;
				}
		
	}

}
