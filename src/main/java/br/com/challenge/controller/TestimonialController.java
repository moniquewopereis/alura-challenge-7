package br.com.challenge.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.testimonial.DataListingTestimonial;
import br.com.challenge.testimonial.Testimonial;
import br.com.challenge.testimonial.TestimonialData;
import br.com.challenge.testimonial.TestimonialDataUpdate;
import br.com.challenge.testimonial.TestimonialRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {
	
	@Autowired
	private TestimonialRepository repository;
	
	@PostMapping
	@Transactional
	public void registerTestimonial(@RequestBody @Valid TestimonialData data) {
		repository.save(new Testimonial(data));	
	}
	
	@GetMapping
    public Page<DataListingTestimonial> list(Pageable page) {
        return repository.findAllByActiveTrue(page).map(DataListingTestimonial::new);
	}
	
	 @PutMapping
	 @Transactional
	 public void updateTestimonial(@RequestBody @Valid TestimonialDataUpdate data) {
		 var testimonial = repository.getReferenceById(data.id());
		 testimonial.update(data);
	 }
	 
	 @DeleteMapping("/{id}")
	 @Transactional
	 public void deleteTestimonial(@PathVariable Long id) {
		 var testimonial = repository.getReferenceById(id);
		 testimonial.delete();
	 }

}
