(ns c-omanage-registry-core-api.specs.co-person-message
  (:require [clojure.spec.alpha :as s]
            [spec-tools.data-spec :as ds]
            [c-omanage-registry-core-api.specs.co-person :refer :all]
            [c-omanage-registry-core-api.specs.co-group-member :refer :all]
            [c-omanage-registry-core-api.specs.email-address :refer :all]
            [c-omanage-registry-core-api.specs.co-person-role :refer :all]
            [c-omanage-registry-core-api.specs.identifier :refer :all]
            [c-omanage-registry-core-api.specs.name :refer :all]
            [c-omanage-registry-core-api.specs.ssh-key :refer :all]
            [c-omanage-registry-core-api.specs.url :refer :all]
            [c-omanage-registry-core-api.specs.org-identity :refer :all]
            )
  (:import (java.io File)))


(def co-person-message-data
  {
   (ds/opt :CoPerson) co-person-spec
   (ds/opt :CoGroupMember) (s/coll-of co-group-member-spec)
   (ds/opt :EmailAddress) (s/coll-of email-address-spec)
   (ds/opt :CoPersonRole) (s/coll-of co-person-role-spec)
   (ds/opt :Identifier) (s/coll-of identifier-spec)
   (ds/opt :Name) (s/coll-of name-spec)
   (ds/opt :SshKey) (s/coll-of ssh-key-spec)
   (ds/opt :Url) (s/coll-of url-spec)
   (ds/opt :OrgIdentity) (s/coll-of org-identity-spec)
   })

(def co-person-message-spec
  (ds/spec
    {:name ::co-person-message
     :spec co-person-message-data}))
