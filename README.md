## Demonstrates using Google Cloud Deploy with a Java Project

![](artifacts/CloudDeploy.jpg)

This is a complete pipeline demonstrating:
1. Continuous integration process once a code is merged into the "main" branch of a project
2. Building an image once the tests are done
3. Deploying the image into a dev/test environment
4. Manual promotion of a deployment to prod environment

## Resources
- cloudbuild.yaml holds the CI pipeline steps
- clouddeploy.yaml holds the CD pipeline steps

## Deployment
- Create a Cloud Build Trigger:
  - Using [Cloud Console](https://cloud.google.com/build/docs/automating-builds/create-manage-triggers)
  - OR using command line:
      ```shell
      gcloud beta builds triggers create github --repo-name hello-skaffold-gke --repo-owner bijukunjummen --branch-pattern '^main$' --name hello-skaffold-gke-exp --build-config cloudbuild.yaml
      ```
- Create a Deployment Pipeline -
    ```sh
    gcloud deploy apply --file=clouddeploy.yaml --region=us-west1
    ```
