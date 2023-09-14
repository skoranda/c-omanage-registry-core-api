(defproject c-omanage-registry-core-api "1.0.0"
  :description "A collection of higher level APIs for COmanage Registry that provide transaction-oriented operations.
Note that the Core API must be configured/enabled and the available functionality depends on the
service configuration details."
  :url "https://spaces.at.internet2.edu/display/COmanage/About+the+COmanage+Project"
  :license {:name "APACHE LICENSE, VERSION 2.0"
            :url "https://www.apache.org/licenses/LICENSE-2.0.html"}
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [metosin/spec-tools "0.7.0"]
                 [clj-http "3.8.0"]
                 [orchestra "2017.11.12-1"]
                 [cheshire "5.8.0"]])