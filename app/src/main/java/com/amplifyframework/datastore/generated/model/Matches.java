package com.amplifyframework.datastore.generated.model;


import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Matches type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Matches", authRules = {
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.READ, ModelOperation.CREATE, ModelOperation.UPDATE })
})
public final class Matches implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField USER_NAME = field("UserName");
  public static final QueryField EMAIL = field("Email");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String UserName;
  private final @ModelField(targetType="String") String Email;
  public String getId() {
      return id;
  }
  
  public String getUserName() {
      return UserName;
  }
  
  public String getEmail() {
      return Email;
  }
  
  private Matches(String id, String UserName, String Email) {
    this.id = id;
    this.UserName = UserName;
    this.Email = Email;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Matches matches = (Matches) obj;
      return ObjectsCompat.equals(getId(), matches.getId()) &&
              ObjectsCompat.equals(getUserName(), matches.getUserName()) &&
              ObjectsCompat.equals(getEmail(), matches.getEmail());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserName())
      .append(getEmail())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Matches {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("UserName=" + String.valueOf(getUserName()) + ", ")
      .append("Email=" + String.valueOf(getEmail()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Matches justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Matches(
      id,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      UserName,
      Email);
  }
  public interface BuildStep {
    Matches build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep userName(String userName);
    BuildStep email(String email);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String UserName;
    private String Email;
    @Override
     public Matches build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Matches(
          id,
          UserName,
          Email);
    }
    
    @Override
     public BuildStep userName(String userName) {
        this.UserName = userName;
        return this;
    }
    
    @Override
     public BuildStep email(String email) {
        this.Email = email;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String userName, String email) {
      super.id(id);
      super.userName(userName)
        .email(email);
    }
    
    @Override
     public CopyOfBuilder userName(String userName) {
      return (CopyOfBuilder) super.userName(userName);
    }
    
    @Override
     public CopyOfBuilder email(String email) {
      return (CopyOfBuilder) super.email(email);
    }
  }
  
}
