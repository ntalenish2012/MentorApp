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

/** This is an auto generated class representing the QuizResults type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "QuizResults", authRules = {
  @AuthRule(allow = AuthStrategy.PRIVATE, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class QuizResults implements Model {
  public static final QueryField ID = field("id");
  public static final QueryField QONE = field("Qone");
  public static final QueryField QTWO = field("Qtwo");
  public static final QueryField QTHREE = field("Qthree");
  public static final QueryField QFOUR = field("Qfour");
  public static final QueryField QFIVE = field("Qfive");
  public static final QueryField QSIX = field("Qsix");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String Qone;
  private final @ModelField(targetType="String") String Qtwo;
  private final @ModelField(targetType="String") String Qthree;
  private final @ModelField(targetType="String") String Qfour;
  private final @ModelField(targetType="String") String Qfive;
  private final @ModelField(targetType="String") String Qsix;
  public String getId() {
      return id;
  }
  
  public String getQone() {
      return Qone;
  }
  
  public String getQtwo() {
      return Qtwo;
  }
  
  public String getQthree() {
      return Qthree;
  }
  
  public String getQfour() {
      return Qfour;
  }
  
  public String getQfive() {
      return Qfive;
  }
  
  public String getQsix() {
      return Qsix;
  }
  
  private QuizResults(String id, String Qone, String Qtwo, String Qthree, String Qfour, String Qfive, String Qsix) {
    this.id = id;
    this.Qone = Qone;
    this.Qtwo = Qtwo;
    this.Qthree = Qthree;
    this.Qfour = Qfour;
    this.Qfive = Qfive;
    this.Qsix = Qsix;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      QuizResults quizResults = (QuizResults) obj;
      return ObjectsCompat.equals(getId(), quizResults.getId()) &&
              ObjectsCompat.equals(getQone(), quizResults.getQone()) &&
              ObjectsCompat.equals(getQtwo(), quizResults.getQtwo()) &&
              ObjectsCompat.equals(getQthree(), quizResults.getQthree()) &&
              ObjectsCompat.equals(getQfour(), quizResults.getQfour()) &&
              ObjectsCompat.equals(getQfive(), quizResults.getQfive()) &&
              ObjectsCompat.equals(getQsix(), quizResults.getQsix());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getQone())
      .append(getQtwo())
      .append(getQthree())
      .append(getQfour())
      .append(getQfive())
      .append(getQsix())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("QuizResults {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("Qone=" + String.valueOf(getQone()) + ", ")
      .append("Qtwo=" + String.valueOf(getQtwo()) + ", ")
      .append("Qthree=" + String.valueOf(getQthree()) + ", ")
      .append("Qfour=" + String.valueOf(getQfour()) + ", ")
      .append("Qfive=" + String.valueOf(getQfive()) + ", ")
      .append("Qsix=" + String.valueOf(getQsix()))
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
  public static QuizResults justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new QuizResults(
      id,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      Qone,
      Qtwo,
      Qthree,
      Qfour,
      Qfive,
      Qsix);
  }
  public interface BuildStep {
    QuizResults build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep qone(String qone);
    BuildStep qtwo(String qtwo);
    BuildStep qthree(String qthree);
    BuildStep qfour(String qfour);
    BuildStep qfive(String qfive);
    BuildStep qsix(String qsix);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String Qone;
    private String Qtwo;
    private String Qthree;
    private String Qfour;
    private String Qfive;
    private String Qsix;
    @Override
     public QuizResults build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new QuizResults(
          id,
          Qone,
          Qtwo,
          Qthree,
          Qfour,
          Qfive,
          Qsix);
    }
    
    @Override
     public BuildStep qone(String qone) {
        this.Qone = qone;
        return this;
    }
    
    @Override
     public BuildStep qtwo(String qtwo) {
        this.Qtwo = qtwo;
        return this;
    }
    
    @Override
     public BuildStep qthree(String qthree) {
        this.Qthree = qthree;
        return this;
    }
    
    @Override
     public BuildStep qfour(String qfour) {
        this.Qfour = qfour;
        return this;
    }
    
    @Override
     public BuildStep qfive(String qfive) {
        this.Qfive = qfive;
        return this;
    }
    
    @Override
     public BuildStep qsix(String qsix) {
        this.Qsix = qsix;
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
    private CopyOfBuilder(String id, String qone, String qtwo, String qthree, String qfour, String qfive, String qsix) {
      super.id(id);
      super.qone(qone)
        .qtwo(qtwo)
        .qthree(qthree)
        .qfour(qfour)
        .qfive(qfive)
        .qsix(qsix);
    }
    
    @Override
     public CopyOfBuilder qone(String qone) {
      return (CopyOfBuilder) super.qone(qone);
    }
    
    @Override
     public CopyOfBuilder qtwo(String qtwo) {
      return (CopyOfBuilder) super.qtwo(qtwo);
    }
    
    @Override
     public CopyOfBuilder qthree(String qthree) {
      return (CopyOfBuilder) super.qthree(qthree);
    }
    
    @Override
     public CopyOfBuilder qfour(String qfour) {
      return (CopyOfBuilder) super.qfour(qfour);
    }
    
    @Override
     public CopyOfBuilder qfive(String qfive) {
      return (CopyOfBuilder) super.qfive(qfive);
    }
    
    @Override
     public CopyOfBuilder qsix(String qsix) {
      return (CopyOfBuilder) super.qsix(qsix);
    }
  }
  
}
