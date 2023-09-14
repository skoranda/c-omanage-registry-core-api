(ns c-omanage-registry-core-api.specs.ad-hoc-attribute
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def ad-hoc-attribute-data
  {
   (ds/opt :meta) meta-spec
   (ds/req :tag) string?
   (ds/opt :value) string?
   })

(def ad-hoc-attribute-spec
  (ds/spec
    {:name ::ad-hoc-attribute
     :spec ad-hoc-attribute-data}))
