<template>
    <v-app>
        <v-app-bar app>
            <v-toolbar-title>Astro</v-toolbar-title>
            <v-btn text
                   v-if="profile"
                   :disabled="$route.path === '/'"
                   @click="showMessages">
                Messages
            </v-btn>
            <v-spacer></v-spacer>
<!--            <v-btn text-->
<!--                   :disabled="$route.path === '/profile'"-->
<!--                   @click="showProfile">-->
<!--                <v-avatar v-if="profile" size="36" class="mr-3">-->
<!--                    <img :src="profile.userpic"-->
<!--                         :alt="profile.name"-->
<!--                    >-->
<!--                </v-avatar>-->
<!--                <span v-if="profile">{{profile.name}}</span>-->
<!--            </v-btn>-->
            <v-btn v-if="status.loggedIn" icon v-on:click="logoutAction">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-app-bar>
        <v-content>

            <router-view></router-view>
        </v-content>
    </v-app>
</template>

<script>
    import { mapState, mapMutations, mapActions } from 'vuex'
    import { addHandler } from "util/ws";

    export default {
        computed: {
            ...mapState({
                user: state => state.auth.user,
                status: state => state.auth.status,
                profile: state => state.messages.profile
            })
        },
        //mapState(['profile']),
        methods: {
            ...mapMutations(['addMessageMutation', 'updateMessageMutation', 'removeMessageMutation']),
            ...mapActions('auth', [
                'logout'//, // -> this['some/nested/module/foo']()
                //'some/nested/module/bar'  // -> this['some/nested/module/bar']()
            ]),
            logoutAction() {
                // this.logout()
                // this.$router.push('/')
                this.$store.dispatch('auth/logout');
                this.$router.push('/login');
            },
            showMessages() {
                this.$router.push('/')
            },
            showProfile() {
                this.$router.push('/profile')
            }
        },
        created() {
            addHandler(data => {
                if (data.objectType === 'MESSAGE') {
                    //const index = this.messages.findIndex(item => item.id === data.body.id)

                    switch (data.eventType) {
                        case 'CREATE':
                            this.addMessageMutation(data.body)
                            break
                        case 'UPDATE':
                            this.updateMessageMutation(data.body)
                            break
                        case 'REMOVE':
                            this.removeMessageMutation(data.body)
                            break
                        default:
                            console.error(`Looks like the event type is unknown "${data.objectType}"`)
                    }


                } else {
                    console.error(`Looks like the object type is unknown "${data.eventType}"`)
                }
            })
        },
        beforeMount() {
            if (!this.profile) {
                this.$router.replace('/login')
            }
        }
    }
</script>

<style>

</style>