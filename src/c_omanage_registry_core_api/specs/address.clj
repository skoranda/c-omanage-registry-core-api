(ns c-omanage-registry-core-api.specs.address
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def address-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :country) string?
   (ds/opt :description) string?
   (ds/opt :language) string?
   (ds/opt :locality) string?
   (ds/opt :postal_code) string?
   (ds/opt :room) string?
   (ds/opt :state) string?
   (ds/opt :street) string?
   (ds/opt :type) string?
   })

(def address-spec
  (ds/spec
    {:name ::address
     :spec address-data}))
