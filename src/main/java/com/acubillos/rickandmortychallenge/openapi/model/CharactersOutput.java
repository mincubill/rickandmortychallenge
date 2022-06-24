package com.acubillos.rickandmortychallenge.openapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.Objects;

/**
 * CharactersOutput
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-22T22:50:32.230Z")


public class CharactersOutput   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private String status = null;

  @JsonProperty("species")
  private String species = null;

  @JsonProperty("type")
  private String type = null;

  @JsonProperty("episode_count")
  private Integer episodeCount = null;

  @JsonProperty("origin")
  private LocationOutput origin = null;

  public CharactersOutput id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public CharactersOutput name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CharactersOutput status(String status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public CharactersOutput species(String species) {
    this.species = species;
    return this;
  }

  /**
   * Get species
   * @return species
  **/
  @ApiModelProperty(value = "")


  public String getSpecies() {
    return species;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public CharactersOutput type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  **/
  @ApiModelProperty(value = "")


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public CharactersOutput episodeCount(Integer episodeCount) {
    this.episodeCount = episodeCount;
    return this;
  }

  /**
   * Get episodeCount
   * @return episodeCount
  **/
  @ApiModelProperty(value = "")


  public Integer getEpisodeCount() {
    return episodeCount;
  }

  public void setEpisodeCount(Integer episodeCount) {
    this.episodeCount = episodeCount;
  }

  public CharactersOutput origin(LocationOutput origin) {
    this.origin = origin;
    return this;
  }

  /**
   * Get origin
   * @return origin
  **/
  @ApiModelProperty(value = "")

  @Valid

  public LocationOutput getOrigin() {
    return origin;
  }

  public void setOrigin(LocationOutput origin) {
    this.origin = origin;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CharactersOutput charactersOutput = (CharactersOutput) o;
    return Objects.equals(this.id, charactersOutput.id) &&
        Objects.equals(this.name, charactersOutput.name) &&
        Objects.equals(this.status, charactersOutput.status) &&
        Objects.equals(this.species, charactersOutput.species) &&
        Objects.equals(this.type, charactersOutput.type) &&
        Objects.equals(this.episodeCount, charactersOutput.episodeCount) &&
        Objects.equals(this.origin, charactersOutput.origin);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, status, species, type, episodeCount, origin);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CharactersOutput {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    species: ").append(toIndentedString(species)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    episodeCount: ").append(toIndentedString(episodeCount)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

