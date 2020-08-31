
package acme.features.patron.banner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.banner.Banner;
import acme.entities.roles.Patron;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractUpdateService;

@Service
public class PatronBannerUpdateService implements AbstractUpdateService<Patron, Banner> {

	// Internal State

	@Autowired
	PatronBannerRepository repository;


	// Service Interface

	@Override
	public boolean authorise(final Request<Banner> request) {
		assert request != null;
		//Comprueba que el principal es un patron y es propietario del banner a mostrar
		Integer principalId = request.getPrincipal().getActiveRoleId();
		Patron p = this.repository.findPatronById(principalId);

		Integer bannerId = request.getModel().getInteger("id");
		Banner b = this.repository.findOneById(bannerId);

		return b.getPatron().equals(p);
	}

	@Override
	public void bind(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);

	}

	@Override
	public void unbind(final Request<Banner> request, final Banner entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "picture", "slogan", "targetUrl", "creditCard");

	}

	@Override
	public Banner findOne(final Request<Banner> request) {
		assert request != null;

		Banner result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void validate(final Request<Banner> request, final Banner entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void update(final Request<Banner> request, final Banner entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
