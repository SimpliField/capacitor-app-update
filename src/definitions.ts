export interface AppUpdatePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
