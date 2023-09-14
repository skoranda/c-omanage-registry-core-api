(ns c-omanage-registry-core-api.specs.telephone-number
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def telephone-number-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :country_code) string?
   (ds/opt :area_code) string?
   (ds/req :number) string?
   (ds/opt :extension) string?
   (ds/opt :description) string?
   (ds/opt :type) string?
   })

(def telephone-number-spec
  (ds/spec
    {:name ::telephone-number
     :spec telephone-number-data}))
