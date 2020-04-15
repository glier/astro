<template>
    <v-container>
        <v-layout justify-space-around>
            <v-flex>
                <div class="title mb-3">User profile</div>
                <v-layout row justify-space-between>
                    <v-flex class="px-1" :xs3="!$vuetify.breakpoint.xs&&!$vuetify.breakpoint.sm">
<!--                        <v-img :src="profile.userpic"></v-img>-->
                        <p>User pic here</p>
                    </v-flex>
                    <v-flex class="px-1">
                        <v-layout column>
<!--                            <v-flex>{{profile.name}}</v-flex>-->
<!--                            <v-flex>{{profile.locale}}</v-flex>-->
<!--                            <v-flex>{{profile.gender}}</v-flex>-->
<!--                            <v-flex>{{currentUser.email}}</v-flex>-->
                            <v-flex>{{user.email}}</v-flex>
<!--                            <v-flex>{{profile.lastVisit}}</v-flex>-->
                        </v-layout>
                    </v-flex>
                </v-layout>
            </v-flex>
        </v-layout>
    </v-container>
</template>

<script>
    import { mapState } from 'vuex'
    export default {
        //name: 'User',
        //computed: mapState(['user'])
        computed: {
            ...mapState({
                user: state => state.auth.user,
                status: state => state.auth.status
            })
            // currentUser() {
            //     return this.$store.state.auth.user;
            // }
        },
        methods: {
        beforeMount() {
            if (!status.loggedIn) {
                this.$router.replace('/login')
            }
        }
        }
    }
</script>

<style scoped>

</style>