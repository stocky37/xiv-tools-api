package dev.stocky37.xiv.api;

import com.fasterxml.jackson.annotation.JsonView;
import dev.stocky37.xiv.api.json.Views;
import dev.stocky37.xiv.core.JobService;
import dev.stocky37.xiv.model.Job;
import java.util.Collection;
import java.util.Optional;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/jobs")
public class JobsApi {

	@Inject JobService jobs;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(Views.Standard.class)
	public Collection<Job> list(@QueryParam("type") Optional<Job.Type> type) {
		return jobs.getAll(type);
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@JsonView(Views.Detailed.class)
	public Optional<Job> get(@PathParam String id) {
		return jobs.findByIdentifier(id);
	}
}
