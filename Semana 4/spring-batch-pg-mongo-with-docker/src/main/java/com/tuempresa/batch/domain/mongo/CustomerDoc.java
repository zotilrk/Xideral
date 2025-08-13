package com.tuempresa.batch.domain.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Setter
@NoArgsConstructor
@Getter
@AllArgsConstructor
@Builder
@Document(collection = "customer_profiles")
public class CustomerDoc {

    @Id
    private String id;
    private String fullName;
    private String email;
    private String emailDomain;
    private boolean active;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getEmailDomain() { return emailDomain; }
    public void setEmailDomain(String emailDomain) { this.emailDomain = emailDomain; }
    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
