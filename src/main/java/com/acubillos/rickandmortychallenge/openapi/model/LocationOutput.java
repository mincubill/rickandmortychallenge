package com.acubillos.rickandmortychallenge.openapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * LocationOutput
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2022-06-22T22:50:32.230Z")


public class LocationOutput   {
  @JsonProperty("name")
  private String name = null;

  @JsonProperty("url")
  private String url = null;

  @JsonProperty("dimension")
  private String dimension = null;

  @JsonProperty("residents")
  @Valid
  private List<String> residents = null;

  public LocationOutput name(String name) {
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

  public LocationOutput url(String url) {
    this.url = url;
    return this;
  }

  /**
   * Get url
   * @return url
  **/
  @ApiModelProperty(value = "")


  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public LocationOutput dimension(String dimension) {
    this.dimension = dimension;
    return this;
  }

  /**
   * Get dimension
   * @return dimension
  **/
  @ApiModelProperty(value = "")


  public String getDimension() {
    return dimension;
  }

  public void setDimension(String dimension) {
    this.dimension = dimension;
  }

  public LocationOutput residents(List<String> residents) {
    this.residents = residents;
    return this;
  }

  public LocationOutput addResidentsItem(String residentsItem) {
    if (this.residents == null) {
      this.residents = new ArrayList<String>();
    }
    this.residents.add(residentsItem);
    return this;
  }

  /**
   * Get residents
   * @return residents
  **/
  @ApiModelProperty(value = "")


  public List<String> getResidents() {
    return residents;
  }

  public void setResidents(List<String> residents) {
    this.residents = residents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LocationOutput locationOutput = (LocationOutput) o;
    return Objects.equals(this.name, locationOutput.name) &&
        Objects.equals(this.url, locationOutput.url) &&
        Objects.equals(this.dimension, locationOutput.dimension) &&
        Objects.equals(this.residents, locationOutput.residents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, url, dimension, residents);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LocationOutput {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
    sb.append("    dimension: ").append(toIndentedString(dimension)).append("\n");
    sb.append("    residents: ").append(toIndentedString(residents)).append("\n");
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

