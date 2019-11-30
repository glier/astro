<template>
    <v-container> <!--v-if="!profile"-->
        Необходимо авторизоваться через
        <v-btn href="/login">Google</v-btn>
    </v-container>
</template>

<script>
    export default {
        name: "Auth"
    }
</script>

<style scoped>

</style>