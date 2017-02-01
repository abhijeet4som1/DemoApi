package com.demo.resource;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.demo.conf.TaskModel;
import com.demo.service.TaskService;
import com.google.inject.Inject;

@Path(value = "/v1/tasks")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TaskResource extends AbstractResource {

    private static final Logger LOG = LoggerFactory.getLogger(TaskResource.class);

    @Inject
    private TaskService taskService;

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    protected String getPath() {
        return "/v1/tasks";
    }

    @GET
    @Path("/get-init-task")
    public Response getInitialTasks() {
        return ok(taskService.getInitialTasks());
    }

    @POST
    @Path("/add-task/")
    public Response addTasks(@Valid TaskModel taskModel) {
        return ok(taskService.addTasks(taskModel));
    }

}
