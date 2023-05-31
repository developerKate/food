package com.example.food;

import java.io.Serializable;
import java.lang.Boolean;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.List;

public class root implements Serializable {
  private List<Hits> hits;

  private Hits._links _links;

  private Integer count;

  private Integer from;

  private Integer to;

  public List<Hits> getHits() {
    return this.hits;
  }

  public void setHits(List<Hits> hits) {
    this.hits = hits;
  }

  public Hits._links get_links() {
    return this._links;
  }

  public void set_links(Hits._links _links) {
    this._links = _links;
  }

  public Integer getCount() {
    return this.count;
  }

  public void setCount(Integer count) {
    this.count = count;
  }

  public Integer getFrom() {
    return this.from;
  }

  public void setFrom(Integer from) {
    this.from = from;
  }

  public Integer getTo() {
    return this.to;
  }

  public void setTo(Integer to) {
    this.to = to;
  }

  public static class Hits implements Serializable {
    private _links _links;

    private Recipe recipe;

    public _links get_links() {
      return this._links;
    }

    public void set_links(_links _links) {
      this._links = _links;
    }

    public Recipe getRecipe() {
      return this.recipe;
    }

    public void setRecipe(Recipe recipe) {
      this.recipe = recipe;
    }

    public static class _links implements Serializable {
      private Next next;

      private Next self;

      public Next getNext() {
        return this.next;
      }

      public void setNext(Next next) {
        this.next = next;
      }

      public Next getSelf() {
        return this.self;
      }

      public void setSelf(Next self) {
        this.self = self;
      }

      public static class Next implements Serializable {
        private String href;

        private String title;

        public String getHref() {
          return this.href;
        }

        public void setHref(String href) {
          this.href = href;
        }

        public String getTitle() {
          return this.title;
        }

        public void setTitle(String title) {
          this.title = title;
        }
      }
    }

    public static class Recipe implements Serializable {
      private String shareAs;

      private List<String> instructions;

      private String co2EmissionsClass;

      private List<String> mealType;

      private String source;

      private Float totalCO2Emissions;

      private List<String> cuisineType;

      private Object totalNutrients;

      private Integer yield;

      private List<Digest> digest;

      private List<Ingredients> ingredients;

      private Object totalDaily;

      private List<String> ingredientLines;

      private String image;

      private Images images;

      private List<String> cautions;

      private List<String> healthLabels;

      private String externalId;

      private String label;

      private Float calories;

      private String uri;

      private String url;

      private List<String> tags;

      private List<String> dietLabels;

      private List<String> dishType;

      private Float totalWeight;

      private Integer glycemicIndex;

      public String getShareAs() {
        return this.shareAs;
      }

      public void setShareAs(String shareAs) {
        this.shareAs = shareAs;
      }

      public List<String> getInstructions() {
        return this.instructions;
      }

      public void setInstructions(List<String> instructions) {
        this.instructions = instructions;
      }

      public String getCo2EmissionsClass() {
        return this.co2EmissionsClass;
      }

      public void setCo2EmissionsClass(String co2EmissionsClass) {
        this.co2EmissionsClass = co2EmissionsClass;
      }

      public List<String> getMealType() {
        return this.mealType;
      }

      public void setMealType(List<String> mealType) {
        this.mealType = mealType;
      }

      public String getSource() {
        return this.source;
      }

      public void setSource(String source) {
        this.source = source;
      }

      public Float getTotalCO2Emissions() {
        return this.totalCO2Emissions;
      }

      public void setTotalCO2Emissions(Float totalCO2Emissions) {
        this.totalCO2Emissions = totalCO2Emissions;
      }

      public List<String> getCuisineType() {
        return this.cuisineType;
      }

      public void setCuisineType(List<String> cuisineType) {
        this.cuisineType = cuisineType;
      }

      public Object getTotalNutrients() {
        return this.totalNutrients;
      }

      public void setTotalNutrients(Object totalNutrients) {
        this.totalNutrients = totalNutrients;
      }

      public Integer getYield() {
        return this.yield;
      }

      public void setYield(Integer yield) {
        this.yield = yield;
      }

      public List<Digest> getDigest() {
        return this.digest;
      }

      public void setDigest(List<Digest> digest) {
        this.digest = digest;
      }

      public List<Ingredients> getIngredients() {
        return this.ingredients;
      }

      public void setIngredients(List<Ingredients> ingredients) {
        this.ingredients = ingredients;
      }

      public Object getTotalDaily() {
        return this.totalDaily;
      }

      public void setTotalDaily(Object totalDaily) {
        this.totalDaily = totalDaily;
      }

      public List<String> getIngredientLines() {
        return this.ingredientLines;
      }

      public void setIngredientLines(List<String> ingredientLines) {
        this.ingredientLines = ingredientLines;
      }

      public String getImage() {
        return this.image;
      }

      public void setImage(String image) {
        this.image = image;
      }

      public Images getImages() {
        return this.images;
      }

      public void setImages(Images images) {
        this.images = images;
      }

      public List<String> getCautions() {
        return this.cautions;
      }

      public void setCautions(List<String> cautions) {
        this.cautions = cautions;
      }

      public List<String> getHealthLabels() {
        return this.healthLabels;
      }

      public void setHealthLabels(List<String> healthLabels) {
        this.healthLabels = healthLabels;
      }

      public String getExternalId() {
        return this.externalId;
      }

      public void setExternalId(String externalId) {
        this.externalId = externalId;
      }

      public String getLabel() {
        return this.label;
      }

      public void setLabel(String label) {
        this.label = label;
      }

      public Float getCalories() {
        return this.calories;
      }

      public void setCalories(Float calories) {
        this.calories = calories;
      }

      public String getUri() {
        return this.uri;
      }

      public void setUri(String uri) {
        this.uri = uri;
      }

      public String getUrl() {
        return this.url;
      }

      public void setUrl(String url) {
        this.url = url;
      }

      public List<String> getTags() {
        return this.tags;
      }

      public void setTags(List<String> tags) {
        this.tags = tags;
      }

      public List<String> getDietLabels() {
        return this.dietLabels;
      }

      public void setDietLabels(List<String> dietLabels) {
        this.dietLabels = dietLabels;
      }

      public List<String> getDishType() {
        return this.dishType;
      }

      public void setDishType(List<String> dishType) {
        this.dishType = dishType;
      }

      public Float getTotalWeight() {
        return this.totalWeight;
      }

      public void setTotalWeight(Float totalWeight) {
        this.totalWeight = totalWeight;
      }

      public Integer getGlycemicIndex() {
        return this.glycemicIndex;
      }

      public void setGlycemicIndex(Integer glycemicIndex) {
        this.glycemicIndex = glycemicIndex;
      }

      public static class Digest implements Serializable {
        private String schemaOrgTag;

        private Object sub;

        private Float total;

        private String unit;

        private Float daily;

        private Boolean hasRDI;

        private String label;

        private String tag;

        public String getSchemaOrgTag() {
          return this.schemaOrgTag;
        }

        public void setSchemaOrgTag(String schemaOrgTag) {
          this.schemaOrgTag = schemaOrgTag;
        }

        public Object getSub() {
          return this.sub;
        }

        public void setSub(Object sub) {
          this.sub = sub;
        }

        public Float getTotal() {
          return this.total;
        }

        public void setTotal(Float total) {
          this.total = total;
        }

        public String getUnit() {
          return this.unit;
        }

        public void setUnit(String unit) {
          this.unit = unit;
        }

        public Float getDaily() {
          return this.daily;
        }

        public void setDaily(Float daily) {
          this.daily = daily;
        }

        public Boolean getHasRDI() {
          return this.hasRDI;
        }

        public void setHasRDI(Boolean hasRDI) {
          this.hasRDI = hasRDI;
        }

        public String getLabel() {
          return this.label;
        }

        public void setLabel(String label) {
          this.label = label;
        }

        public String getTag() {
          return this.tag;
        }

        public void setTag(String tag) {
          this.tag = tag;
        }
      }

      public static class Ingredients implements Serializable {
        private Float quantity;

        private String measure;

        private String foodId;

        private Float weight;

        private String text;

        private String food;

        public Float getQuantity() {
          return this.quantity;
        }

        public void setQuantity(Float quantity) {
          this.quantity = quantity;
        }

        public String getMeasure() {
          return this.measure;
        }

        public void setMeasure(String measure) {
          this.measure = measure;
        }

        public String getFoodId() {
          return this.foodId;
        }

        public void setFoodId(String foodId) {
          this.foodId = foodId;
        }

        public Float getWeight() {
          return this.weight;
        }

        public void setWeight(Float weight) {
          this.weight = weight;
        }

        public String getText() {
          return this.text;
        }

        public void setText(String text) {
          this.text = text;
        }

        public String getFood() {
          return this.food;
        }

        public void setFood(String food) {
          this.food = food;
        }
      }

      public static class Images implements Serializable {
        private REGULAR REGULAR;

        private REGULAR SMALL;

        private REGULAR LARGE;

        private REGULAR THUMBNAIL;

        public REGULAR getREGULAR() {
          return this.REGULAR;
        }

        public void setREGULAR(REGULAR REGULAR) {
          this.REGULAR = REGULAR;
        }

        public REGULAR getSMALL() {
          return this.SMALL;
        }

        public void setSMALL(REGULAR SMALL) {
          this.SMALL = SMALL;
        }

        public REGULAR getLARGE() {
          return this.LARGE;
        }

        public void setLARGE(REGULAR LARGE) {
          this.LARGE = LARGE;
        }

        public REGULAR getTHUMBNAIL() {
          return this.THUMBNAIL;
        }

        public void setTHUMBNAIL(REGULAR THUMBNAIL) {
          this.THUMBNAIL = THUMBNAIL;
        }

        public static class REGULAR implements Serializable {
          private Integer width;

          private String url;

          private Integer height;

          public Integer getWidth() {
            return this.width;
          }

          public void setWidth(Integer width) {
            this.width = width;
          }

          public String getUrl() {
            return this.url;
          }

          public void setUrl(String url) {
            this.url = url;
          }

          public Integer getHeight() {
            return this.height;
          }

          public void setHeight(Integer height) {
            this.height = height;
          }
        }
      }
    }
  }
}
