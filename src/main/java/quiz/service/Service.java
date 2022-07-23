package quiz.service;

import quiz.domain.Domain;
import quiz.response.Response;

public interface Service<D extends Domain> {
    Response<D> create(D domain);
}
