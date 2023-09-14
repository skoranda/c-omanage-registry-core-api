(ns c-omanage-registry-core-api.specs.url
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.meta :refer :all]
            )
  (:import (java.io File)))


(def url-data
  {
   (ds/opt :meta) meta-spec
   (ds/opt :description) string?
   (ds/req :url) string?
   (ds/opt :type) string?
   })

(def url-spec
  (ds/spec
    {:name ::url
     :spec url-data}))
