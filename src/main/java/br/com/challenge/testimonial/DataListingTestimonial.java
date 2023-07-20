package br.com.challenge.testimonial;

public record DataListingTestimonial(String name, String testimonial, String photo) {
	
	public DataListingTestimonial(Testimonial testimonial) {
        this(testimonial.getName(), testimonial.getTestimonial(), testimonial.getPhoto());
        
	}
}
