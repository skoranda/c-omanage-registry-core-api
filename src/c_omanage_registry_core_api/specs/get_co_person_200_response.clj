(ns c-omanage-registry-core-api.specs.get-co-person-200-response
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.co-person-message :refer :all]
            )
  (:import (java.io File)))


(def get-co-person-200-response-data
  {
   (ds/opt :0) co-person-message-spec
   (ds/opt :currentPage) string?
   (ds/opt :itemsPerPage) string?
   (ds/opt :pageCount) string?
   (ds/opt :startIndex) string?
   (ds/opt :totalResults) string?
   })

(def get-co-person-200-response-spec
  (ds/spec
    {:name ::get-co-person-200-response
     :spec get-co-person-200-response-data}))
