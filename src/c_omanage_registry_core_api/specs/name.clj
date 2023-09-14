(ns c-omanage-registry-core-api.specs.name
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def name-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :given) string?
   (ds/opt :family) string?
   (ds/opt :formatted) string?
   (ds/opt :language) string?
   (ds/opt :middle) string?
   (ds/opt :prefix) string?
   (ds/opt :primary_name) boolean?
   (ds/opt :honorific) string?
   (ds/opt :suffix) string?
   (ds/opt :type) string?
   })

(def name-spec
  (ds/spec
    {:name ::name
     :spec name-data}))
