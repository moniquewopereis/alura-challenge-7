package br.com.challenge.testimonial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "testimonials")
@Entity(name = "Testimonial")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Testimonial {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String testimonial;
	private String photo;
	private boolean active;
	
	public Testimonial(TestimonialData data) {
        this.testimonial = data.testimonial();
        this.name = data.name();
        this.photo = data.photo();
        this.active = true;
	}

	public void update(TestimonialDataUpdate data) {
		if (data.testimonial() != null) {
            this.testimonial = data.testimonial();
		}
        if (data.photo() != null) {
            this.photo = data.photo();
        }
        if (data.active() != false) {
        	this.active = true;
        }
	}

	public void delete() {
		this.active = false;
	}
}

	
